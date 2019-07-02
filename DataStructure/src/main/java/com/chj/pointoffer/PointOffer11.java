package com.chj.pointoffer;

import org.junit.Test;

/**
 *  求旋转数组的最小值。
 *  思路，使用两个高低指针逼近最小值。最终，两个指针分别在最大值和最小值身上，并且相邻。
 */
public class PointOffer11 {
    @Test
    public void solution() {
        int arr[] = new int[]{3,4,5,1,2};
        System.out.println(findMin(arr));
    }

    public int findMin(int []arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low != high-1) {  // 最终，两个指针分别在最大值和最小值身上，并且相邻。
            int middle = (low + high) / 2;
            if (arr[middle] > arr[low]){
                low = middle;
            }else {
                high = middle;
            }
        }
        return arr[high];
    }
}
