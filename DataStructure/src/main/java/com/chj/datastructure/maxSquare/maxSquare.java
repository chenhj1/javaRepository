package com.chj.datastructure.maxSquare;

/**
 * 动态规划，最大正方形
 * Created by chenhaojie on 2018/05/30.
 */
public class maxSquare {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 0, 1, 1, 1}};
//        int arr[][]={{1 ,0, 1, 0 ,0},{1 ,1 ,1 ,1 ,1},{1, 1, 1 ,1, 1},{1 ,0 ,0 ,1 ,0}};
        System.out.print(maxSize(arr));

    }


    public static int maxSize(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int border = 0;
        int[][] dp = new int[rows + 1][cols + 1];//一个存储状态的数组。

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = min(dp[i][j], dp[i][j + 1], dp[i + 1][j]) + 1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }

                border = border > dp[i + 1][j + 1] ? border : dp[i + 1][j + 1];
            }
        }
        return border * border;

    }

    public static int min(int a, int b, int c) {
        int small = a > b ? b : a;
        return small > c ? c : small;
    }
}
