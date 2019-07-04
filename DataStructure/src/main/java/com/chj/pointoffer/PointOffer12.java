package com.chj.pointoffer;

import org.junit.Test;

/**
 * 查找一个二维矩阵中是否包含某个路径。
 *
 * FIXME 有bug待修复
 */
public class PointOffer12 {

    @Test
    public void solution() {
        char[][] arr = new char[][]{{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
//        char desArr[] = new char[]{'b', 'f', 'c', 'e'};
        char desArr[] = new char[]{'b', 'f'};
//        char[][] arr = new char[][]{{'a', 'b'}, {'c', 'f'}};
//        char desArr[] = new char[]{'a','c','f'};
        System.out.println(find(arr, desArr));
    }

    public boolean find(char[][] arr, char[] desArr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (findCorePath(i, j, arr, visited, desArr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findCorePath(int i, int j, char[][] arr, boolean[][] visited, char[] desArr, int desArrIndex) {

        if (desArrIndex >= desArr.length - 1) {
            return true;
        }

        if (i < 0 || i >= arr.length || j > 0 || j >= arr[0].length || arr[i][j] != desArr[desArrIndex] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (findCorePath(i - 1, j, arr, visited, desArr, desArrIndex + 1) ||
                findCorePath(i + 1, j, arr, visited, desArr, desArrIndex + 1) ||
                findCorePath(i, j - 1, arr, visited, desArr, desArrIndex + 1) ||
                findCorePath(i, j + 1, arr, visited, desArr, desArrIndex + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;

    }
}
