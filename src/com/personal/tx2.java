package com.personal;

import java.util.Scanner;

/**
 * @description:
 * @author: liuXiaoHan
 * @date: 2021-09-26 20:04
 **/
public class tx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            int res = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                res = Math.max(res, help(j, nums));
            }
            System.out.println(res);
        }
    }
    public static int help(int start, int[] nums) {
        int sum = 0;
        while (start < nums.length) {
            sum += nums[start];
            start += sum;
//            System.out.println(start);
        }
        return sum;
    }
}
