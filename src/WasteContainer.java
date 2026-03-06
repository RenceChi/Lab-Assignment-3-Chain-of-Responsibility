class WasteContainer {
    private boolean isFull;
    private String type;
    private int capacity;

    public WasteContainer(String type, int capacity, boolean isFull) {
        this.type = type;
        this.capacity = capacity;
        this.isFull = isFull;
    }

    public String getType() {
        return type;
    }

    public boolean isFull() {
        return isFull;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " Waste Container (" + capacity + "L)";
    }
}