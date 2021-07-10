package com.yubin.algorithms;

/**
 * 对数器的使用
 *  使用对数器验证选择排序的正确性
 * @author YUBIN
 * @create 2021-03-13
 */
public class Code0008_Comp {

    public static void main(String[] args) {
        int maxLen = 5;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = lenRandAndValueRand(maxLen, maxValue);
            int[] tmp = copyArr(arr1);
            selectionSort(arr1);
            if (!isSorted(arr1)) {
                for (int j = 0; j < tmp.length; j++) {
                    System.out.print(tmp[j] + " ");
                }
                System.out.println();
                System.out.println("选择排序错了！");
                break;
            }
        }
    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 返回一个长度随机, 值随机的数组
    private static int[] lenRandAndValueRand(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int v = (int) (Math.random() * maxValue);
            arr[i] = v;
        }
        return arr;
    }

    private static int[] copyArr(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // 验证数组里面的元素是否排好序
    private static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            Math.max(max, arr[i]);
        }
        return true;
    }
}
