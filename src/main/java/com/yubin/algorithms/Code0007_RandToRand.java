package com.yubin.algorithms;

/**
 * 介绍随机函数的使用
 * @author YUBIN
 * @create 2021-03-13
 */
public class Code0007_RandToRand {

    public static void main(String[] args) {
        // 验证Math.random()函数[0,1)是等概率的
        int testTimes = 10000000;
        int count = 0;

        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75) { // 其概率应该是0.7
                count++;
            }
        }
        System.out.println((double)count / (double)testTimes);

        System.out.println("===========================");

        // [0,1)*8 => [0,8)
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) { // 其概率应该是 5/8=0.625
                count++;
            }
        }
        System.out.println((double)count / (double)testTimes);

        System.out.println("===========================");

        int k = 9;
        // [0,k) => [0,l-1]
        int[] counts = new int[k];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数,出现了" + counts[i] + "次");
        }
        System.out.println("===========================");

        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (xToPower2() < 0.7) {
                count++;
            }
        }
        System.out.println((double)count / (double)testTimes);
        System.out.println(1 - Math.pow((1 - 0.7), 2));
        System.out.println("===========================");

        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println((double)count / (double)testTimes);
        System.out.println("===========================");

        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int ans = g();
            counts[ans]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数,出现了" + counts[i] + "次");
        }
        System.out.println("===========================");
    }

    private static double xToPower2() {
        return Math.min(Math.random(), Math.random());
    }

    /**
     * 返回[1,5]的等概率随机数
     * 假设该方法是lib里面,不能修改
     * @return
     */
    private static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 随机机制,等概率返回0和1 只能使用f1函数
     * 分析 f1函数是等概率返回[1,5]的整数
     * 那么1,2,3,4,5的概率分别是20%， 如果我使用1和2 表示0; 4和5表示1 当遇到3的时候再次随机即将得到3的概率分摊到其它4个数上面,
     * 此时得到1、2、4、5的概率都是25%，因此得到0的概率就是50%，得到1的概率也是50%
     *
     * @return
     */
    private static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);

        return ans < 3 ? 0 : 1;
    }

    // 得到000 ~ 111 做到等概率 0 ~ 7等概率返回一个 每一个数的概率是1/8
    private static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }

    // 0 ~ 6等概率返回一个
    private static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);

        return ans;
    }

    // 1 ~ 7等概率返回一个
    private static int g() {
        return f4() + 1;
    }

    // 已知的01不等概论函数，但是0和1的概率是固定的
    private static int x() {
        return Math.random() > 0.84 ? 0 : 1;
    }

    // 通过x函数得到01的等概率随机
    private static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());

        return ans;
    }
}
