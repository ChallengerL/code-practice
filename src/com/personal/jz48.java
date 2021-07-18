package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * @author liuxiaohan1
 * @date 2021-07-17 9:27 下午
 */
public class jz48 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

}
