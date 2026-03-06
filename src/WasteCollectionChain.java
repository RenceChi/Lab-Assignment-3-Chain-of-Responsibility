public interface WasteCollectionChain {
    void setNextChain(WasteCollectionChain nextChain);
    void collect(WasteContainer container);
}
