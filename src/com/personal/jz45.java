package com.personal;

import java.util.Random;

/**
 * 把数组排成最小的数
 * @author liuxiaohan1
 * @date 2021-07-16 1:55 下午
 */
public class jz45 {

    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        quickSort(str, 0, str.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : str) {
            res.append(s);
        }
        return res.toString();
    }

    public void quickSort(String[] str, int left, int right) {
        if (left < right) {
            int pos = partition(str, left, right);
            quickSort(str, left, pos - 1);
            quickSort(str, pos + 1, right);
        }
    }
    public int partition(String[] str, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(str, left, randomIndex);
        String temp = str[left];
        while (left < right) {
            while (left < right && (str[right] + temp).compareTo(temp + str[right]) >= 0) {
                right--;
            }
            str[left] = str[right];
            while (left < right && (str[left] + temp).compareTo(temp + str[left]) <= 0) {
                left++;
            }
            str[right] = str[left];
        }
        str[left] = temp;
        return left;
    }

    public void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
