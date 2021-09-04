package com.personal;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.math.BigInteger;
import java.util.*;

/**
 * @author liuxiaohan1
 * @date 2021-07-14 12:01 下午
 */
import java.util.Scanner;


public class Solution {
    public static int modNum = 1000000000 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
//        System.out.println(list);
        int count = nums.length;
        while (--count != 0) {
            for (int i = 0; i < count; i++) {
                nums[i] -= nums[i + 1];
            }
        }
        System.out.println(nums[0] % (modNum));
    }

}


//
//public class Solution {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = sc.nextInt();
//            int res = 0;
//            int[] map = new int[100001];
//            for (int j = 0; j < n; j++) {
//                int day = sc.nextInt();
//                map[j + 1] = day;
//                int pre = sc.nextInt();
//                if (pre == 0) {
//                    res = Math.max(res, day);
//                } else {
//                    int[] nums = new int[pre];
//                    for (int k = 0; k < pre; k++) {
//                        nums[k] = sc.nextInt();
//                    }
//                    int days = 0;
//                    for (int num : nums) {
//                        days = Math.max(days, map[num]) ;
//                    }
//                    map[j + 1] += days;
//                    res = Math.max(res, day + days);
//                }
//
//            }
//            System.out.println(res);
//        }
//    }
//}

//public class Solution {
//    final static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int[][] grid = new int[300][300];
//        String s = null;
//        int count = 0;
//        while (!(s = sc.nextLine()).equals("")) {
//            String[] split = s.split(",");
//            for (int i = 0; i < split.length; i++) {
//                grid[count][i] = (Integer.parseInt(split[i]));
//            }
//            count++;
//        }
//        System.out.println(Arrays.toString(grid[0]));
//        System.out.println(Arrays.toString(grid[1]));
//        System.out.println(Arrays.toString(grid[2]));
//        System.out.println(Arrays.toString(grid[3]));
//        System.out.println(nums(grid));
//    }
//    public static int nums(int[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int r = grid.length;
//        int c = grid[0].length;
//        int res = 0;
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                if (grid[i][j] == 1) {
//                    res++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
//        return res;
//    }
//    public static void dfs(int[][] grid, int r, int c) {
//        if (!inArea(grid, r, c) || grid[r][c] != 1) {
//            return;
//        }
//        grid[r][c] = 2;
//        dfs(grid, r - 1, c);
//        dfs(grid, r + 1, c);
//        dfs(grid, r, c - 1);
//        dfs(grid, r, c + 1);
//    }
//    public  static boolean inArea(int[][] grid, int r, int c) {
//        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
//    }
//}
//
//
//    String s = "aabcddd";
//    int start = 0;
//    int res = 0;
//    HashMap<Character, Integer> map = new HashMap<>();
//    int left = 0;
//    int right = 0;
//        for (int i = 0; i < s.length(); i++) {
//        if (map.containsKey(s.charAt(i))) {
//        start = Math.max(map.get(s.charAt(i)) + 1, start);
//        }
//        map.put(s.charAt(i), i);
//        res = Math.max(res, i - start + 1);
//        left = i - start + 1;
//        right = res + 1;
//        }
//        System.out.println(s.substring(left, right));
//        System.out.println(res);
//public class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for(int i = 0; i < t; i++){
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int k = 1;
//            while (true) {
//                if (String.valueOf(m * k).length() == n) {
//                    System.out.println(m * k);
//                    break;
//                }
//                k++;
//            }
//        }
//    }
//}
//public class Solution {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
////        System.out.println(Arrays.toString(nums));
//        int m = in.nextInt();
//        for (int i = 0; i < m; i++) {
//            if (in.nextInt() == 1) {
//                int a = in.nextInt();
//                int b = in.nextInt();
//                int sum = 0;
//                for (int j = a - 1; j < b; j++) {
//                    sum += nums[j];
//                }
//                System.out.println(sum);
//            }
//            if (in.nextInt() == 2) {
//                int a = in.nextInt();
//                int b = in.nextInt();
//                long sum = 0;
//                long pre = 0;
//                for (int j = a - 1; j < b; j++) {
//                    pre += nums[j];
//                }
//                System.out.println(pre);
//                for (int j = a - 1; j < b; j++) {
//                    sum += (pre - nums[j]) * (pre - nums[j]);
//                }
//                System.out.println(sum);
//            }
//            if (in.nextInt() == 3) {
//                int a = in.nextInt();
//                int b = in.nextInt();
//                int max = Integer.MIN_VALUE;
//                for (int j = a - 1; j < b; j++) {
//                    max = Math.max(max, nums[j]);
//                }
//                System.out.println(max);
//            }
//        }
//    }
//}

//public class Solution {
//    static boolean[] visited;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//        visited = new boolean[nums.length];
////        System.out.println(Arrays.toString(nums));
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        LinkedList<Integer> track = new LinkedList<>();
//        backtrack(nums, 0, res, track);
//        System.out.println(res.size());
//        for (List<Integer> re : res) {
//            for (int i = 0; i < re.size() - 1; i++) {
//                System.out.print(re.get(i) + " ");
//            }
//            System.out.println(re.get(re.size() - 1));
//        }
//    }
//    public static void backtrack(int[] nums, int index, List<List<Integer>> res, LinkedList<Integer> track) {
//        if (index == nums.length) {
//            res.add(new ArrayList<Integer>(track));
////            System.out.println(track);
////            for (int i = 0; i < track.size() - 1; i++) {
////                System.out.print(track.get(i) + " ");
////            }
////            System.out.println(track.get(track.size() - 1));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
//                continue;
//            }
//            track.add(nums[i]);
//            visited[i] = true;
//            backtrack(nums, index + 1, res, track);
//            visited[i] = false;
//            track.remove(index);
//        }
//    }
//}


//public class Solution {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        StringBuilder s = new StringBuilder(in.nextLine());
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            int a = in.nextInt();
//            if (a == 2) {
//                int b = in.nextInt();
////                System.out.println(a + "," + b);
//                int juli = Integer.MAX_VALUE;
//                for (int j = 0; j < s.length(); j++) {
//                    if (j == b - 1) {
//                        continue;
//                    }
//                    if (s.charAt(j) == s.charAt(b - 1)) {
//                        juli = Math.min(Math.abs(j - b + 1), juli);
//                    }
//                }
//                if (juli == Integer.MAX_VALUE) {
//                    System.out.println(-1);
//                } else {
//                    System.out.println(juli);
//                }
//            }
//            if (a == 1) {
//                String b = in.next();
////                System.out.println(a + "," + b);
//                s.append(b);
////                System.out.println(s);
//            }
//
//        }
////        String[] s1 = s.split(" ");
////        for (int i = 0; i < s1.length; i++) {
////            nums[i] = Integer.parseInt(s1[i]);
////        }
////        int n = in.nextInt();
////        System.out.println(Arrays.toString(nums));
////        System.out.println(n);
//    }
//
//}
