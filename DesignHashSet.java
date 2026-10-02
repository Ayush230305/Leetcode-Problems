public class DesignHashSet {
    private boolean[] storage;
    public DesignHashSet() {
        storage = new boolean[1_000_001];
    }
    public void add(int key) {
        storage[key] = true;
    }
    public void remove(int key) {
        storage[key] = false;
    }
    public boolean contains(int key) {
        return storage[key];
    }
}

