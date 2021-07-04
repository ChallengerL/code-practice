package com.personal;

/**
 * 字符串相乘
 * @author liuxiaohan1
 * @date 2021-07-04 4:02 下午
 */
public class lc43 {

    public String multiply(String nums1, String nums2) {
        if (nums1.equals("0") || nums2.equals("0")) {
            return "0";
        }
        int[] res = new int[nums1.length() + nums2.length()];
        for (int i = nums1.length() - 1; i >= 0 ; i--) {
            int n1 = nums1.charAt(i) - '0';
            for (int j = nums2.length() - 1; j >= 0; j--) {
                int n2 = nums2.charAt(j) - '0';
                int sum = res[i + j + 1] + n1 * n2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

}
