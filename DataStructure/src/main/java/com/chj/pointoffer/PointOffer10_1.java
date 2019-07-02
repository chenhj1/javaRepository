package com.chj.pointoffer;

import org.junit.Test;

/**
 * 斐波那契数列
 */
public class PointOffer10_1 {
    @Test
    public void solution() {
        System.out.println(feibonaqie(7));
        System.out.println(feibonaqieFor(7));
    }

    // 递归实现
    public int feibonaqie(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return feibonaqie(n - 1) + feibonaqie(n - 2);
    }

    // 循环实现
    public int feibonaqieFor(int n){

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int now = 0;
        int pre = 1;
        int prePre = 0;
        for (int i=2;i<=n;i++){
            now = pre + prePre;
            prePre = pre;
            pre = now;
        }
        return now;

    }
}
