package com.personal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LFU
 * @author liuxiaohan1
 * @date 2021-07-04 9:00 下午
 */
public class lc460 {

    class LFUCache {
        // 键值映射
        Map<Integer, Node> keyVal;
        // 频率
        Map<Integer, LinkedList<Node>> freqKey;
        // 最小频次
        int minFreq;
        // 缓存最大容量
        int capacity;

        public LFUCache(int capacity) {
            this.keyVal = new HashMap<>();
            this.freqKey = new HashMap<>();
            this.minFreq = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!keyVal.containsKey(key) || capacity == 0) {
                return -1;
            }
            //增加freq
            keyVal.get(key).freq++;
            return keyVal.get(key).val;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            // 已存在key
            if (keyVal.containsKey(key)) {
                Node node = keyVal.get(key);
                node.val = value;
                node.freq = 1;
                keyVal.put(key, node);
                return;
            }
            // 不存在key，添加前先判断容量
            if (this.capacity == keyVal.size()) {
                // 移除使用频率最低的元素
                removeMinFreqKey();
            }
            // 添加

            keyVal.put(key, value);
            keyFreq.put(key, );
            increaseFreq(key);
        }

        public void increaseFreq(int key) {

        }

        public void removeMinFreqKey() {

        }

    }

    private static class Node {
        int key, val, freq;
        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

}
