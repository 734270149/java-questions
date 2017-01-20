package sg;

import java.util.HashMap;

/**
 * Created by shiguang3 on 2016/7/8.
 */
public class LRUCache<K, V> {
    private int capacity;
    private HashMap<K, CacheEntry<K, V>> map;
    private CacheEntry<K, V> head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<K, CacheEntry<K, V>>((int) (capacity / .75f) + 1);
        head = new CacheEntry<K, V>(null, null);
        tail = new CacheEntry<K, V>(null, null);
        head.next = tail;
        tail.pre = head;
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            CacheEntry<K, V> cEntry = map.get(key);
            moveToHead(cEntry);
            return cEntry.value;
        } else {
            return null;
        }
    }

    public V put(K key, V value) {
        if (map.containsKey(key)) {
            CacheEntry<K, V> cEntry = map.get(key);
            V old = cEntry.value;
            cEntry.value = value;
            moveToHead(cEntry);
            return old;
        } else {
            CacheEntry<K, V> cEntry = new CacheEntry<K, V>(key, value);
            moveToHead(cEntry);
            map.put(key, cEntry);
            if (map.size() == capacity) {
                removeEnd();
            }
            return null;
        }
    }

    private void removeEnd() {
        CacheEntry<K, V> cEntry = tail.pre;
        tail.pre.pre.next = tail;
        tail.pre = cEntry.pre;
        cEntry.pre = null;
        cEntry.next = null;
        map.remove(cEntry.key);
    }

    private void moveToHead(CacheEntry<K, V> cEntry) {
        if (cEntry.next != null && cEntry.pre != null) {
            cEntry.pre.next = cEntry.next;
            cEntry.next.pre = cEntry.pre;
        }
        cEntry.pre = head;
        cEntry.next = head.next;
        head.next.pre = cEntry;
        head.next = cEntry;
    }

    private static final class CacheEntry<K, V> {
        K key;
        V value;
        CacheEntry<K, V> pre;
        CacheEntry<K, V> next;

        private CacheEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
}
