package com.personal;

/**
 * 接雨水
 *
 * @author liuxiaohan1
 * @date 2021-06-08 16:01
 */
public class lc42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int len = height.length;
        int left = 0, right = len - 1;
        int l_max = height[left], r_max = height[right];
        int ans = 0;
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if (l_max < r_max) {
                ans += l_max - height[left];
                left++;
            } else {
                ans += r_max - height[right];
                right--;
            }
        }
        return ans;
    }

}
