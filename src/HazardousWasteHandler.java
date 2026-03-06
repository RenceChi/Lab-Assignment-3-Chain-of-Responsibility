public class HazardousWasteHandler implements WasteCollectionChain {
    private WasteCollectionChain chain;

    @Override
    public void setNextChain(WasteCollectionChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void collect(WasteContainer container) {
        if (container.getType().equalsIgnoreCase("Hazardous") && container.isFull()) {
            System.out.println("Hazardous Handler: Safely neutralizing " + container.getCapacity() + "L of hazardous waste.");
        } else {
            if (this.chain != null) {
                this.chain.collect(container);
            } else {
                System.out.println("Warning: No handler found for " + container.getType() + " waste.");
            }
        }
    }
}
