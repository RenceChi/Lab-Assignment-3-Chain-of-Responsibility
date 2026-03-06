public class WasteManagementChain implements WasteCollectionChain {
    private WasteCollectionChain nextChain;

    public WasteManagementChain() {
        // According to the <<create>> arrows in the diagram, this class
        // takes responsibility for building the handlers and linking the chain.
        WasteCollectionChain organic = new OrganicWasteHandler();
        WasteCollectionChain recyclable = new RecyclableWasteHandler();
        WasteCollectionChain hazardous = new HazardousWasteHandler();

        // Link the chain: Organic -> Recyclable -> Hazardous
        organic.setNextChain(recyclable);
        recyclable.setNextChain(hazardous);

        // Set the head of the chain
        this.nextChain = organic;
    }

    @Override
    public void setNextChain(WasteCollectionChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void collect(WasteContainer container) {
        if (this.nextChain != null) {
            this.nextChain.collect(container);
        }
    }
}
