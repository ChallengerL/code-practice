package com.personal;

/**
 * 跳跃游戏
 * @author liuxiaohan1
 * @date 2021-07-17 5:12 下午
 */
public class lc55 {

    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }

}
