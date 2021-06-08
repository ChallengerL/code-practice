package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author liuxiaohan1
 * @date 2021-06-07 17:04
 */
public class lc3 {

    public int lengthOfLongestSubstring(String s) {
        //
        if (s.length() == 0) return 0;
        int start = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

}
