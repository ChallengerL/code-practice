package com.personal;

/**
 * @author liuxiaohan1
 * @date 2021-07-14 12:01 下午
 */
public class Solution {
    public String changespaceto20 (String str) {
        // write code here
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
