package com.personal;

import java.util.Random;

/**
 * 最小的k个数
 * @author liuxiaohan1
 * @date 2021-07-06 11:18 上午
 */
public class jz40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int left, int right, int k) {
        if (left < right) {
            int pos = partition(arr, left, right);
            int num = pos - left + 1;
            if (num == k) {
                return;
            } else if (k < num) {
                quickSort(arr, left, pos - 1, k);
            } else {
                quickSort(arr, pos + 1, right, k - num);
            }
        }
    }

    public int partition(int[] arr, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(arr, left, randomIndex);
        int pivot = arr[left];
        int lt = left + 1, gt = right;
        while (true) {
            while (lt <= right && arr[lt] < pivot) {
                lt++;
            }
            while (gt >= left && arr[gt] > pivot) {
                gt--;
            }
            if (lt >= gt) {
                break;
            }
            swap(arr, lt, gt);
            lt++;
            gt--;
        }
        swap(arr, left, gt);
        return gt;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
