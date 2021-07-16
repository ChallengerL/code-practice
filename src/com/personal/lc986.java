package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间列表的交集
 * @author liuxiaohan1
 * @date 2021-07-16 10:36 上午
 */
public class lc986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length, m = secondList.length;
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
