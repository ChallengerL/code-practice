package com.personal;

/**
 * 两数之和2 - 输入有序数组
 * @author liuxiaohan1
 * @date 2021-07-08 9:12 下午
 */
public class lc167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            }else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

}
