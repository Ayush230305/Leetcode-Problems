public class DesignHashMap {
    int key, val;
    DesignHashMap next;
    public DesignHashMap(int key, int val, DesignHashMap next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
class MyHashMap {
    static final int size = 19997;
    static final int mult = 12582917;
    DesignHashMap[] data;
    public MyHashMap() {
        this.data = new DesignHashMap[size];
    }
    private int hash(int key) {
        return (int)((long)key * mult % size);
    }
    public void put(int key, int val) {
        remove(key);
        int h = hash(key);
        DesignHashMap node = new DesignHashMap(key, val, data[h]);
        data[h] = node;
    }
    public int get(int key) {
        int h = hash(key);
        DesignHashMap node = data[h];
        for (; node != null; node = node.next)
            if (node.key == key) return node.val;
        return -1;
    }
    public void remove(int key) {
        int h = hash(key);
        DesignHashMap node = data[h];
        if (node == null) return;
        if (node.key == key) data[h] = node.next;
        else for (; node.next != null; node = node.next)
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
    }
}

