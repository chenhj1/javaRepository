package com.chj.pointoffer;

import org.junit.Test;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class PointOffer4 {

    @Test
    public void solution() {
        int[][] arr = new int[][]{
                {1, 2, 8,  9},
                {2, 4, 9,  12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(findFromArr(arr, 7));
    }

    public boolean findFromArr(int[][] arr, int des) {
        int width = arr[0].length;
        int hight = arr.length;

        int j = width - 1;
        for (int i = 0; i < hight - 1; i++) {
            for (; j > 0; j--) {
                if (arr[i][j] == des) {
                    return true;
                } else if (des > arr[i][j]) {
                    break;
                }
            }
        }
        return false;
    }
}
