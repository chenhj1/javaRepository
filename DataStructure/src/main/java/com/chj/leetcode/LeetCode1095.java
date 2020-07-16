package com.chj.leetcode;

/**
 * （这是一个 交互式问题 ）也叫双调查找。
 *
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 */
public class LeetCode1095 {
    public static void main(String [] args) {
        int []arr = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(LeetCode1095.binSearch(arr, 1, 0, arr.length-1));
    }

    // TODO 待完成
    private static int findK(int []arr, int k, int left, int right) {
        return 0;
    }

    // 二分找最大值
    private static int findMax(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid == 0) {
                if (arr[mid] > arr[mid+1]){
                    return 0;
                }else {
                    return 1;
                }
            }

            if (mid == arr.length-1) {
                if (arr[mid] > arr[mid-1]){
                    return arr.length - 1;
                }else {
                    return arr.length - 2;
                }
            }

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 先写一个二分查找
    private static int binSearch(int []arr, int k, int left, int right) {
        while (left < right) {
            int mid = (left + right ) /2;
            if (k>arr[mid]){
                left = mid;
            }else if (k<arr[mid]){
                right = mid;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
