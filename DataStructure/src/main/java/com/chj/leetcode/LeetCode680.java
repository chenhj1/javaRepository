package com.chj.leetcode;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 */
public class LeetCode680 {
    public static void main(String[] args) {
        String s = "abb1a";
        System.out.println(judge(s));
    }

    private static boolean judge(String s) {
        char[] charArr = s.toCharArray();
        boolean usedChance = false;
        for (int i = 0, j = charArr.length - 1; i <= j; ) {
            if (charArr[i] == charArr[j]) {
                i++;
                j--;
            } else {
                if (charArr[i + 1] == charArr[j] && !usedChance) {
                    usedChance = true;
                    i = i + 2;
                    j--;
                } else if (charArr[i] == charArr[j - 1] && !usedChance) {
                    usedChance = true;
                    i++;
                    j = j - 2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
