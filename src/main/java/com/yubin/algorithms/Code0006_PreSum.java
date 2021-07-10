package com.yubin.algorithms;

/**
 * 使用前缀数组求和
 *  案例：假设有一个数组arr，用户总是非常频繁的查询arr中某一段的累加和你如何组织数据，能让这种查询变得便利和快捷？
 *
 *  方案1:
 *      使用二维数组的方式,分别将0~0的和放在二维数组的[0][0]位置, 0~1的和放在二维数组的[0][1]...按此规则组合二维数组
 *  方案2:
 *      使用前缀数组(前缀和)来存在(一维数组),前缀数组的第0个位置放0~0的和, 第1个位置放0~1的和 .. 第n-1个位置放0~n-1的和,
 *      当需要求arr数组L~R之间的和时,算法为 L==0? h[R] : h[R] - H[L-1]
 *
 *      假设arr数组的长度为N
 *       定义的二维数组是 h[N][N]
 *       定义的一维数组是 h[N]
 * @author YUBIN
 * @create 2021-03-13
 */
public class Code0006_PreSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        RangeSum1 rangeSum1 = new RangeSum1(arr);
        RangeSum2 rangeSum2 = new RangeSum2(arr);
        System.out.println(rangeSum1.rangeSum(3, 5));
        System.out.println(rangeSum2.rangeSum(3, 5));
    }

    // 原始遍历L~R之间的元素求和的方式
    private static class RangeSum1 {

        private int[] arr;

        public RangeSum1(int[] array) {
            arr = array;
        }

        public int rangeSum(int L, int R) {
            int sum = 0;
            for (int i = L; i <= R; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }

    // 使用前缀数组
    private static class RangeSum2 {

        private int[] preSum;

        public RangeSum2(int[] array) {
            int N = array.length;
            preSum = new int[N];
            preSum[0] = array[0];
            for (int i = 1; i < N; i++) {
                preSum[i] = preSum[i - 1] + array[i];
            }
        }

        public int rangeSum(int L, int R) {
            return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
        }

    }
}
