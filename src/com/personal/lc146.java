package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存机制
 *
 * @author liuxiaohan1
 * @date 2021-06-08 10:35
 */
public class lc146 {

    class Node {
        public int key, val;
        public Node prev, next;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0 );
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }
    }

    class LRUCache {
        private Map<Integer, Node> map;
        private DoubleList cache;
        private int cap;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            cache = new DoubleList();
            this.cap = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                deleteKey(key);
                addRecently(key, value);
                return;
            }
            if (cap == cache.size()) {
                removeLeastRecently();
            }
            addRecently(key, value);
        }

        public void deleteKey(int key) {
            Node node = map.get(key);
            cache.remove(node);
            map.remove(key);
        }

        public void makeRecently(int key) {
            Node node = map.get(key);
            cache.remove(node);
            cache.addLast(node);
        }

        public void addRecently(int key, int value) {
            Node node = new Node(key, value);
            map.put(key, node);
            cache.addLast(node);
        }

        public void removeLeastRecently() {
            Node deletedKey = cache.removeFirst();
            map.remove(deletedKey.key);
        }

    }
}
