package com.yubin.algorithms;

/**
 * 插入排序
 *  首先从0~0范围内进行排序，由于只有一个元素所以它已经是一个有序的列表了。
 *  然后从0~1范围内排序，只需要将1和0位置上的元素进行比较，如果1比0小，则将1和0进行交换位置。
 *  然后从0~2范围内排序，首先比较2和1位置上元素的大小，如果2比1小则进行交换，交换完了在对1和0位置上的元素进行比较。如果2比1大则直接结束比较。
 *  ....
 *  最后从0~N-1范围内排序。
 *
 * @author YUBIN
 * @create 2021-03-13
 */
public class Code0005_InsertSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 9, 3, 6, 0, 7, 1, 3, 2};
        printArray(arr);
        insertSort(arr);
        printArray(arr);
    }

    private static void insertSort(int[] arr) {
        // 先考虑边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int end = 1; end < n; end++) {
            // end与end-1 end-1~end-2 .... 1~0进行比较
            for (int j = end - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
                swap(arr, j, j + 1);
            }
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
