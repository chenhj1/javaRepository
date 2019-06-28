package com.chj.pointoffer;

/**
 * 一个数组的元素个数是n，所有元素的大小是0到n-1，随意输出任何一个重复元素
 */
public class PointOffer3 {

    public static void main(String []args){
        int []arr = new int[]{1,2,0,4,2,5};
        System.out.println(getDuplicate(arr));
    }

    public static int getDuplicate(int []arr) {
        for (int i=0;i<arr.length;i++){
            while (arr[i] != i){

                if (arr[i] == arr[arr[i]]){
                    return arr[i];
                }

                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return -1;
    }
}


