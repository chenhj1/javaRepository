package com.chj.datastructure.shangren;

/**
 * Created by chenhaojie on 2018/05/31.
 * 股票在哪一天出售利益最大
 */
public class Shangren {

    public static void main(String []args){
        int []arr = new int[]{20,30,15,25,35,10,12};
        int i ;
        int minFlag = 0;//买入点
        int minTemp = minFlag;//试探买入点
        int maxProfit = 0;//最大利益
        for(i = 1;i<arr.length;i++){
            int profit = arr[i] - arr[minTemp] ;
            if(profit > maxProfit){
                maxProfit = profit;
                minFlag = minTemp ;
            }
            if(arr[i] < arr[minFlag]){
                minTemp = i;
            }
        }

        System.out.println("买入点：" + minFlag);
        System.out.println("最大利益：" + maxProfit);
    }
}
