package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author liuxiaohan1
 * @date 2021-06-08 11:44
 */
public class lc15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSumTarget(nums, 3, 0, 0);
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || n > nums.length) return res;
        if (n == 2) {
            int low = start, high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                int left = nums[low];
                int right = nums[high];
                if (sum < target) {
                    while (low < high && nums[low] == left) low++;
                } else if (sum > target) {
                    while (low < high && nums[high] == right) high--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    while (low < high && nums[low] == left) low++;
                    while (low < high && nums[high] == right) high--;
                }
            }
        } else {
            //
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : sub) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }

}
