package com.personal;

/**
 * 字符串相加
 * @author liuxiaohan1
 * @date 2021-06-26 2:57 下午
 */
public class lc415 {

    public String addStrings(String nums1, String nums2) {
        int i = nums1.length() - 1, j = nums2.length() - 1, add = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? nums1.charAt(i) - '0' : 0;
            int y = j >= 0 ? nums2.charAt(j) - '0' : 0;
            int sum = x + y + add;
            add = sum / 10;
            res.append(sum % 10);
            i--;
            j--;
        }
        res.reverse();
        return res.toString();
    }

}
