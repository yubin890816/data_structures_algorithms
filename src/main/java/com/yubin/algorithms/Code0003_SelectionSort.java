package com.yubin.algorithms;

/**
 * 选择排序
 *  首先从0~N-1上选出最小值放到0位置
 *  然后从1~N-1上选出最小值放到1位置
 *  然后从2~N-1上选出最小值放到2位置
 *  重复之前的步骤，直到所有元素均排序完毕。
 * @author YUBIN
 * @create 2021-03-13
 */
public class Code0003_SelectionSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 9, 3, 6, 0, 7, 1, 3, 2};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        // 先考虑边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    // 打印数组
    private static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
