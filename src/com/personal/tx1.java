package com.personal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: liuXiaoHan
 * @date: 2021-09-26 20:04
 **/
public class tx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();

            int a = 1 + x;
            int b = a + x;
            int n = fun2(a, b);
//            System.out.println(n);
            boolean flag = fun0(n, x);
            while (true) {
                if (!flag) {
                    n++;
//                    System.out.println(n);
                    flag = fun0(n, x);
                } else {
                    break;
                }
            }
            System.out.println(n);
        }
    }
    public static boolean fun0(int n, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
//        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i) - list.get(i + 1)) < x || list.size() < 4) {
                return false;
            }
        }
        return true;
    }
    public static int fun1(int a, int b) {
        int num = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                num = i;
            }
        }
        return num;
    }
    public static int fun2(int a, int b) {
        return a * b / fun1(a, b);
    }
}
