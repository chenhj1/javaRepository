package com.chj.datastructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class MaoPaoSort {

    @Test
    public void sort() {
        int[] arr = new int[]{8, 7, 6, 9, 5, 4, 3, 2, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "轮, " + Arrays.toString(arr));
        }

        System.out.println("\n结果：" + Arrays.toString(arr));

    }
}
