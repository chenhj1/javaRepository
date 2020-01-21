package com.chj.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 翻转一个整数
 */
public class LeetCode7 {
    public static void main(String[] args) {
        System.out.println(Revase(-123));
    }

    private static int Revase(int a) {
        int target = 0;
        boolean flag = false;
        if (a < 0) {
            a = -a;
            flag = true;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        while (a > 0) {
            queue.add(a % 10);
            a = a / 10;
        }
        while (!queue.isEmpty()) {
            target = target * 10 + queue.poll();
        }
        if (flag) {
            target = -target;
        }
        return target;
    }
}
