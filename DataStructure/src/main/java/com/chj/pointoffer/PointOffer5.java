package com.chj.pointoffer;

import org.junit.Test;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class PointOffer5 {

    @Test
    public void solution() {
        char []arr = new char[]{'w','e',' ','a','r','e',' ','h','a','p','p','y','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000'};
        System.out.println(fun(arr));
    }

    public char[] fun(char[] arr) {
        int arrLength = 12;
        int count = 0;
        // 先统计出有多少个空格。
        for (char c : arr) {
            if (c == ' ') {
                count++;
            }
        }
        // 从后往前，摆放元素。遇到空格要替换成%20，占3个位置。
        for (int i = arrLength, j = arrLength + count * 2; i > 0; i--) {
            if (arr[i] == ' ') {
                arr[j] = '0';
                arr[j - 1] = '2';
                arr[j - 2] = '%';
                j = j - 3;
                count--;
            } else {
                arr[j] = arr[i];
                j--;
            }
            if (count == 0){
                break;
            }
        }
        return arr;
    }
}
