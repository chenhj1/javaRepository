package com.chj.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class LeetCode283 {
    public static void main(String []args){
        int []nums = new int []{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void moveZeroes(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (nums[i] == 0){
                for (int j=i;j<nums.length;j++){
                    if (nums[j]!=0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }

            }
        }
    }
}
