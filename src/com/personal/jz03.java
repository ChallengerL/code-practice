package com.personal;

/**
 * 数组中重复的数字
 * @author liuxiaohan1
 * @date 2021-07-17 8:27 下午
 */
public class jz03 {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

}
