package com.yubin.algorithms;

/**
 * 打印int类型整数的二进制位
 *
 * @author YUBIN
 * @create 2021-03-13
 */
public class Code0001_PrintBinary {

    public static void main(String[] args) {
        int num = -1;
        print(num);
    }

    private static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
