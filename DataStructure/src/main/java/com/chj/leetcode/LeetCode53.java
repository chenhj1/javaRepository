package com.chj.leetcode;


/**
 * 求数组的最大连续区间和。
 *
 * 例：
 * 输入：{1，2，5，-7，8，-10}
 * 输出：9 (子数组为: {1，2，5，-7，8})
 */
public class LeetCode53 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, 5, -6, 8, -10};
        System.out.println(getMaxSubArr(arr));
    }

    private static int getMaxSubArr(int[] arr) {

        if (arr.length == 0)
            return 0;

        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;

    }
}
