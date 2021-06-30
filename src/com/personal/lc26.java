package com.personal;

/**
 * 删除排序数组中的重复项
 * @author liuxiaohan1
 * @date 2021-06-30 5:21 下午
 */
public class lc26 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 1;
        while (fast < n) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

}
