package com.personal;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 设计哈希映射
 * @author liuxiaohan1
 * @date 2021-07-12 6:17 下午
 */
public class lc706 {

    class MyHashMap {
        private class Pair {
            private int key;
            private int value;
            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }
            public int getKey() {
                return key;
            }
            public int getValue() {
                return value;
            }
            public void setValue(int value) {
                this.value = value;
            }
        }
        private static final int BASE = 769;
        LinkedList[] data;
        public MyHashMap() {
            data = new LinkedList[BASE];
            for (int i = 0; i < data.length; i++) {
                data[i] = new LinkedList<Pair>();
            }
        }

        public void put(int key, int value) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            }
            data[h].offerLast(new Pair(key, value));
        }

        public int get(int key) {
            int h = hash(key);
            int value;
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    return pair.getValue();
                }
            }
            return -1;
        }

        public void remove(int key) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    data[h].remove(pair);
                    return;
                }
            }
        }

        public int hash(int key) {
            return key % BASE;
        }
    }

}
