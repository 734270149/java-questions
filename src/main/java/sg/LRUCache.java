package sg;

import java.util.HashMap;

/**
 * Created by shiguang3 on 2016/7/8.
 */
public class LRUCache {
    int l_capacity;
    HashMap<Integer, CacheEntry> l_HashMapmap;
    CacheEntry head, tail;

    // use two way linklist
    public LRUCache(int capacity) {
        l_capacity = capacity;
        l_HashMapmap = new HashMap<Integer, CacheEntry>(capacity);
        head = new CacheEntry(-1, -1);
        tail = new CacheEntry(1, 1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {//if contains key, just get value and update
        if (l_HashMapmap.containsKey(key)) {
            CacheEntry cEntry = l_HashMapmap.get(key);
            MoveToHead(cEntry);
            return cEntry.value;
        } else return -1;
    }

    public void set(int key, int value) {
        if (l_HashMapmap.containsKey(key)) {//if map contains key, just update value
            CacheEntry cEntry = l_HashMapmap.get(key);
            cEntry.value = value;
            MoveToHead(cEntry);
        } else if (l_HashMapmap.size() < l_capacity) {//not contain & smaller the size
            CacheEntry cEntry = new CacheEntry(key, value);
            MoveToHead(cEntry);
            l_HashMapmap.put(key, cEntry);
        } else {//not contain key and over the size
            CacheEntry cEntry = new CacheEntry(key, value);
            MoveToHead(cEntry);
            l_HashMapmap.put(key, cEntry);
            int endIndex = removeEnd();
            l_HashMapmap.remove(endIndex);
        }
    }

    private int removeEnd() {
        CacheEntry cEntry = tail.pre;
        tail.pre.pre.next = tail;
        tail.pre = cEntry.pre;
        cEntry.pre = null;
        cEntry.next = null;
        return cEntry.key;
    }

    private void MoveToHead(CacheEntry cEntry) {
        if (cEntry.next != null && cEntry.pre != null) {
            cEntry.pre.next = cEntry.next;
            cEntry.next.pre = cEntry.pre;
        }
        cEntry.pre = head;
        cEntry.next = head.next;
        head.next.pre = cEntry;
        head.next = cEntry;
    }

    class CacheEntry {
        int key;
        int value;
        CacheEntry pre;
        CacheEntry next;

        public CacheEntry(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}
