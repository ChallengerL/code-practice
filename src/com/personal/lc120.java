package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小路径和
 * @author liuxiaohan1
 * @date 2021-07-15 11:15 上午
 */
public class lc120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j)到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        int ans = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                ans = Math.min(ans, triangle.get(i).get(j));
            }
            res.add(ans);
            ans = Integer.MAX_VALUE;
        }
        System.out.println(res);
        System.out.println(dp[0][0]);
        return dp[0][0];
    }

    public static void main(String[] args) {
        lc120 lc120 = new lc120();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        lc120.minimumTotal(list);
    }
}
