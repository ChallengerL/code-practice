package com.personal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 按权重随机选择
 * @author liuxiaohan1
 * @date 2021-07-16 11:33 上午
 */
public class lc528 {

    class Solution {
        int sum = 0;
        // 前缀和数组
        List<Integer> preSum = new ArrayList<>();
        public Solution(int[] w) {
            for (int i : w) {
                sum += i;
                preSum.add(sum);
            }
        }

        public int pickIndex() {
            int target = new Random().nextInt(sum);
            int low = 0, high = preSum.size() - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (target >= preSum.get(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

    }

}
