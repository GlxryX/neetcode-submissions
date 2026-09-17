class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            this.remove(node);
            this.addToTail(node);
            return node.val;
        } else return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node contained = map.get(key);
            this.remove(contained);
            this.addToTail(contained);
            contained.val = value;
            return;
        } else if (map.size() == this.capacity) {
            map.remove(this.head.next.key);
            this.remove(this.head.next);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        this.addToTail(newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(Node node) {
        node.next = this.tail;
        node.prev = this.tail.prev;
        this.tail.prev.next = node;
        this.tail.prev = node;
    }
}
