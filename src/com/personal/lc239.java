package com.personal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值
 * @author liuxiaohan1
 * @date 2021-07-04 5:23 下午
 */
public class lc239 {

    public int[] maxSlidingWindow(int[] nums,int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 维护一个从大到小的有序队列
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 维护左边界
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 结果数组赋值
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

}
