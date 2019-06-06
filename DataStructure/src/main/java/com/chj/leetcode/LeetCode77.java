package com.chj.leetcode;

/**
 * 求两个字符串的最大公共子串
 * 思路：转化成二位矩阵
 */
public class LeetCode77 {
    public static void main(String[] args) {
        String s2 = "abcde";
        String s1 = "bcdefg";
        int[][] martix = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j== 0){
                        martix[i][j] = 1;
                    } else {
                        martix[i][j] = martix[i - 1][j - 1] + 1;
                    }
                } else {
                    martix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                System.out.print(martix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
