package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author liuxiaohan1
 * @date 2021-06-10 14:01
 */
public class lc56 {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0])); // 根据第一个元素进行排序
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (res.size() == 0 || L > res.get(res.size() - 1)[1]) {
                res.add(new int[]{L, R});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
