package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求数组中比左边元素都大同时比右边元素都小的元素，返回这些元素的索引
 * 要求时间复杂度
 * 输入：[2, 3, 1, 8, 9, 20, 12]
 * 输出：3, 4
 * 解释：数组中 8, 9 满足题目要求，他们的索引分别是 3、4
 * @author liuxiaohan1
 * @date 2021-08-05 10:04 上午
 */
public class addition15 {

    public List<Integer> find(int[] nums) {
        int len = nums.length;
        int[] left_max = new int[len];
        int[] right_min = new int[len];
        Arrays.fill(left_max, Integer.MIN_VALUE);
        Arrays.fill(right_min, Integer.MAX_VALUE);
        for (int i = 1; i < len; i++) {
            left_max[i] = Math.max(left_max[i - 1], nums[i - 1]);
        }
        System.out.println(Arrays.toString(left_max));
        for (int i = len - 2; i >= 0; i--) {
            right_min[i] = Math.min(right_min[i + 1], nums[i + 1]);
        }
        System.out.println(Arrays.toString(right_min));
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > left_max[i] && nums[i] < right_min[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 8, 9, 20, 12};
        addition15 addition15 = new addition15();
        List<Integer> res = addition15.find(nums);
        System.out.println(res);
    }

}
