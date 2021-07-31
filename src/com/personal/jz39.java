package com.personal;

/**
 * 数组中出现次数超过一半的数字
 * @author liuxiaohan1
 * @date 2021-07-12 5:31 下午
 */
public class jz39 {

    public int majorityElement(int[] nums) {
        int res = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                res = num;
                votes++;
                continue;
            }
            if (res == num) {
                votes++;
            } else {
                votes--;
            }
        }
        return res;
    }

}
