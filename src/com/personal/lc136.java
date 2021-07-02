package com.personal;

/**
 * @description: 只出现一次的数字
 * @author: liuXiaoHan
 * @date: 2021-07-02 22:33
 **/
public class lc136 {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                res = res ^ nums[i];
            }
        }
        return res;
    }

}
