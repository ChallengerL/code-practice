package com.personal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(yusefu(n));
        }
    }

    public static int yusefu(int n) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int k = 0;
        while (list.size() > 0) {
            k += 3;
            k = k % (list.size()) - 1;
            if (k < 0) {
                res = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                k = 0;
            } else {
//                System.out.println(list.get(k));
                res = list.get(k);
                list.remove(k);
            }
        }
        return res;
    }


//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int m = 0;
//            int n = 0;
//            String s1 = sc.nextLine();
//            for (int i = 0; i < s1.length(); i++) {
//                if (s1.charAt(i) == 'm') {
//                    m = s1.charAt(i + 2) - 48;
//                }
//                if (s1.charAt(i) == 'n') {
//                    n = s1.charAt(i + 2) - 48;
//                }
//            }
////            System.out.println(m);
////            System.out.println(n);
//            String s2 = sc.nextLine();
//            String[] chars1 = s2.split(",");
//            int[] nums1 = new int[m + n];
//            for (int i = 0; i < chars1.length; i++) {
//                nums1[i] = Integer.parseInt(chars1[i]);
//            }
////            System.out.println(Arrays.toString(nums1));
//            String s3 = sc.nextLine();
//            String[] chars2 = s3.split(",");
//            int[] nums2 = new int[n];
//            for (int i = 0; i < chars2.length; i++) {
//                nums2[i] = Integer.parseInt(chars2[i]);
//            }
////            System.out.println(Arrays.toString(nums2));
//            merge(nums1, nums2, m, n);
//            for (int i = 0; i < nums1.length - 1; i++) {
//                System.out.print(nums1[i] + " ");
//            }
//            System.out.println(nums1[nums1.length - 1]);
//        }
//
//    }
//
//    public static void merge(int[] nums1, int[] nums2, int m, int n) {
//        int i = m + n - 1;
//        m--;
//        n--;
//        while (n >= 0) {
//            while (m >= 0 && nums1[m] > nums2[n]) {
//                int temp = nums1[m];
//                nums1[i] = temp;
//                nums1[m] = nums1[i];
//                i--;
//                m--;
//            }
//            nums1[i] = nums2[n];
//            i--;
//            n--;
//        }
//    }
}
