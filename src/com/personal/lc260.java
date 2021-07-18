package com.personal;

/**
 * 只出现一次的数字III
 * @author liuxiaohan1
 * @date 2021-07-17 8:21 下午
 */
public class lc260 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        int mask = xor & (-xor);
        int[] res = new int[2];
        for (int num : nums) {
            if ((mask & num) == 0) {
                res[0] = res[0] ^ num;
            } else {
                res[1] = res[1] ^ num;
            }
        }
        return res;
    }

}
