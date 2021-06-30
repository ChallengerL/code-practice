package com.personal;

/**
 * 最长回文子串
 * @author liuxiaohan1
 * @date 2021-06-29 8:59 下午
 */
public class lc5 {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = findPaliindrome(s, i , i);
            String s2 = findPaliindrome(s, i , i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
    public String findPaliindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

}
