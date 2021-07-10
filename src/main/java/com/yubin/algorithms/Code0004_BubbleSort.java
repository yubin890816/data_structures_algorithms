package com.yubin.algorithms;

/**
 * 冒泡排序
 *  首先从0~N-1上依次比较相邻的两个数（如1跟2比较，2跟3比较...N-2跟N-1比较）如果相邻两个数前一个比后一个大则进行交换，这一圈下来最大的数就会到N-1的位置。
 *  然后从0~N-2上依次比较相邻的两个数（如1跟2比较，2跟3比较...N-3跟N-2比较）如果相邻两个数前一个比后一个大则进行交换，这一圈下来最大的数就会到N-2的位置。
 *  重复之前的步骤，直到所有元素均排序完毕(即最后的0~1上进行比较)
 *
 * @author YUBIN
 * @create 2021-03-13
 */
public class Code0004_BubbleSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 9, 3, 6, 0, 7, 1, 3, 2};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    private static void bubbleSort(int[] arr) {
        // 先考虑边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int end = n - 1; end > 0; end--) {
            // 0~1 1~2 2~3 3~4 (end-1)~end
            for (int second = 1; second <= end; second++) {
                if (arr[second-1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
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
