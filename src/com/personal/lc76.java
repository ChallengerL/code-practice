package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖字串
 *
 * @author liuxiaohan1
 * @date 2021-06-11 09:40
 */
public class lc76 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int count = 0;
        Map<Character,Integer> window = new HashMap<>();
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    count++;
                }
            }
            while (count == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        count--;
                    }
                    window.put(l, window.getOrDefault(l, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
