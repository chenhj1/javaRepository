package com.chj.datastructure.sort;

import net.sf.json.JSONArray;

/**
 * Created by chenhaojie on 2017/10/24.
 *
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] list = {34, 53, 3, 2, 23, 7, 14, 10};
        insertSort(list);
        System.out.println(JSONArray.fromObject(list).toString());
    }

    public static void insertSort(int[] list) {

        int temp = 0;
        int j = 0;

        for (int i = 0; i < list.length; i++) {
            temp = list[i];
            //假如temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < list[j - 1]; j--) {
                list[j] = list[j - 1];
            }
            list[j] = temp;
        }
    }

}
