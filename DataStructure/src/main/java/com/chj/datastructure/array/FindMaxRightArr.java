package com.chj.datastructure.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 打印数组每个元素右边第一个比它大的数字
 */
public class FindMaxRightArr {
    public static void main(String []args) {
//        int []arr = new int[]{4, 6, 5, 7, 3, 10, 5, 4, 6, 2};
        int []arr = new int[]{8, 2, 5, 4, 3, 9, 7, 2, 5};
        System.out.println(Arrays.toString(findMaxRightArr(arr)));
    }
    private static int [] findMaxRightArr(int []array) {
        if(array == null) {
            return array;
        }
        int size = array.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        while(index < size) {
            if(!stack.isEmpty() && array[index] > array[stack.peek()]) {
                result[stack.pop()] = array[index];
            } else {
                stack.push(index);
                index++;
            }
        }
        if(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;

    }
}
