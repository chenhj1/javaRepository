package com.chj.pointoffer;

import java.util.Arrays;

/**
 * 给定一个无序数组，要求把偶数放到奇数右边，不改变偶数与偶数、奇数与奇数之间的想对位置。
 *
 * 思路：冒泡排序，把偶数冒泡到最右侧即可。
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class PointOffer14 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < arr.length;i++ ) {
            for (int j = 0;j<arr.length-i-1;j++)
                if (arr[j] % 2 == 0 && arr[j+1]%2 != 0) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        }

        System.out.println(Arrays.toString(arr));
    }
}
