package com.yubin.algorithms;

/**
 * 阶乘的和
 *  题目: 给定一个参数N, 返回 1!+2!+3!+4!+......+N!
 *  思路:
 *      1! = 1             = 1
 *      2! = 1*2           = 1!*2
 *      3! = 1*2*3         = 2!*3
 *      4! = 1*2*3*4       = 3!*4
 *      .       .              .
 *      .       .              .
 *      .       .              .
 *      N! = 1*2*3*...*N   = (N-1)!*N
 * @author YUBIN
 * @create 2021-03-13
 */
public class Code0002_SumOfFactorial {

    public static void main(String[] args) {
        System.out.println(sumOfFactorial(4));
        System.out.println(sumOfFactorial2(4));
    }

    private static int sumOfFactorial(int num) {
        int sum = 0;
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
            sum += factorial;
        }
        return sum;
    }

    private static int sumOfFactorial2(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += factorial(i);
        }
        return sum;
    }

    private static int factorial(int i) {
        int factorial = 1;
        for (int j = 1; j <= i; j++) {
            factorial *= j;
        }
        return factorial;
    }
}
