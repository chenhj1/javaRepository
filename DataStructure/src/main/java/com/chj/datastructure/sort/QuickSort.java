package com.chj.datastructure.sort;

import net.sf.json.JSONArray;

import java.util.Arrays;

/**
 * 快排，时间复杂度O(nlogn)
 */
public class QuickSort {


    public static int getMiddle(int[] list, int low, int high) {
        int middleValue = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] > middleValue) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] < middleValue) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = middleValue;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    public static void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            quickSort(list, low, middle - 1);        //对低字表进行递归排序
            quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    public static void main(String[] args) {
        int[] list = {28, 3, 53, 2, 23, 7, 14, 10};
        quickSort(list, 0, list.length - 1);
        System.out.println(Arrays.toString(list));
    }

}
