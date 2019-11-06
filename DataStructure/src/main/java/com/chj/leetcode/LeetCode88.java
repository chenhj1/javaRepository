package com.chj.leetcode;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 思路：从后往前。O(n)时间复杂度。
 */
public class LeetCode88 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 8, 0, 0, 0, 0};
        int[] arr2 = new int[]{2, 4, 6, 7};

        int[] result = solution(arr1, arr2, 4, 4);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] arr1, int[] arr2, int m, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; i >= 0 && j >= 0; ) {
            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                i--;
            } else {
                arr1[k] = arr2[j];
                j--;
            }
            k--;
        }
        return arr1;
    }

}
