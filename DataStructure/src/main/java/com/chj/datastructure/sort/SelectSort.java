package com.chj.datastructure.sort;

import net.sf.json.JSONArray;

/**
 * 选择排序
 *
 * Created by chenhaojie on 2017/10/23.
 */
public class SelectSort {

    public static void main(String [] args){
        int[] list = {34, 53, 3, 2, 23, 7, 14, 10};
        selectSort(list);
        System.out.println(JSONArray.fromObject(list).toString());
    }

    public static void selectSort(int [] list){
        for(int i=0;i<list.length;i++){
            int smallest = list[i];
            int smallestFlag=i;
            for(int j=i+1;j<list.length;j++){
                if(list[j]<smallest){
                    smallest=list[j];
                    smallestFlag = j;
                }
            }
            System.out.println(smallest);
            if(smallest<list[i]){
                int temp = list[smallestFlag];
                list[smallestFlag]=list[i];
                list[i]=temp;
            }

        }
    }

}
