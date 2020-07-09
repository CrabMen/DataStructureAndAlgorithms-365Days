import java.util.HashMap;

/**
 * 
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 写入数据 put(key,
 * value) -
 * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 
 *  
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 *  
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2) //缓存容量;
 * 
 * cache.put(1, 1); cache.put(2, 2); cache.get(1); // 返回 1 cache.put(3, 3); //
 * 该操作会使得关键字 2 作废 cache.get(2); // 返回 -1 (未找到) cache.put(4, 4); // 该操作会使得关键字 1
 * 作废 cache.get(1); // 返回 -1 (未找到) cache.get(3); // 返回 3 cache.get(4); // 返回 4
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * 
 * 
 */

/**
 * 
 * 
 * 要让 put 和 get 方法的时间复杂度为 O(1)O(1)，我们可以总结出 cache 这个数据结构必要的条件：查找快，插入快，删除快，有顺序之分。
 * 
 * 因为显然 cache 必须有顺序之分，以区分最近使用的和久未使用的数据；而且我们要在 cache
 * 中查找键是否已存在；如果容量满了要删除最后一个数据；每次访问还要把数据插入到队头。
 * 
 * 那么，什么数据结构同时符合上述条件呢？哈希表查找快，但是数据无固定顺序；链表有顺序之分，插入删除快，但是查找慢。所以结合一下，形成一种新的数据结构：哈希链表。
 * 
 * 作者：labuladong
 * 链接：https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * 
 */

class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();

    }

    public int get(int key) {

        // if (key 不存在) {
        // return -1;
        // } else {
        // 将数据 (key, val) 提到开头；
        // return val;
        // }
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        // Node x = new Node(key, val);
        // if (key 已存在) {
        // 把旧的数据删除；
        // 将新节点 x 插入到开头；
        // } else {
        // if (cache 已满) {
        // 删除链表的最后一个数据腾位置；
        // 删除 map 中映射到该数据的键；
        // }
        // 将新节点 x 插入到开头；
        // map 中新建 key 对新节点 x 的映射；
        // }
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (capacity == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }

    }
}

class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleList {
    private Node head, tail; // 头尾虚节点
    private int size; // 链表元素数

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表头部添加节点 x
    public void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点
    public Node removeLast() {
        if (tail.prev == head)
            return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }

    // 返回链表长度
    public int size() {
        return size;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */