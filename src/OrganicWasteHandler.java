public class OrganicWasteHandler implements WasteCollectionChain {
    private WasteCollectionChain chain;

    @Override
    public void setNextChain(WasteCollectionChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void collect(WasteContainer container) {
        if (container.getType().equalsIgnoreCase("Organic") && container.isFull()) {
            System.out.println("Organic Handler: Composting " + container.getCapacity() + "L of organic waste.");
        } else {
            if (this.chain != null) {
                this.chain.collect(container);
            } else {
                System.out.println("Warning: No handler found for " + container.getType() + " waste.");
            }
        }
    }
}
