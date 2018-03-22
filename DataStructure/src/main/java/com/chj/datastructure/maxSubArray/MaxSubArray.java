package com.chj.datastructure.maxSubArray;

/**
 * 输入一个整形数组，里面有正数也有负数，数组中连续的一个或者几个数字组成子数组。求所有子数组和的最大值，要求时间复杂度O(n)
 * Created by chenhaojie on 2018/03/22.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] num = {1, -2, 3, 10, -4, 7, 2, -5};   //case 1
        //int[] num = {1,-2,3,10,-4,10,2,-5};       //case 2
//        int[] num = {-2, -1, -3};                 //case 3
        System.out.println("子序列和的最大值是：" + maxSum(num));
    }

    public static int maxSum(int[] num) {
        int curSum = 0;//临时记录和
        int maxSum = Integer.MIN_VALUE;//确定和
//        int start = 0;
//        int end = 0;

        for (int i = 0; i < num.length; i++) {
            if (curSum <= 0) {
                curSum = num[i];
//                start = i;
            } else {
                curSum = curSum + num[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
//                end = i;
            }
        }
        //输出最大序列，在case3情况下有bug，但是不影响最大值。
        /*for (int i = start;i <= end ; i++) {
            System.out.print(num[i] + " ");
        }*/
        System.out.println();
        return maxSum;
    }

}
