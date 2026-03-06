public class RecyclableWasteHandler implements WasteCollectionChain{
    private WasteCollectionChain chain;

    @Override
    public void setNextChain(WasteCollectionChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void collect(WasteContainer container) {
        if (container.getType().equalsIgnoreCase("Recyclable") && container.isFull()) {
            System.out.println("Recyclable Handler: Sorting and processing " + container.getCapacity() + "L of recyclables.");
        } else {
            if (this.chain != null) {
                this.chain.collect(container);
            } else {
                System.out.println("Warning: No handler found for " + container.getType() + " waste.");
            }
        }
    }
}
