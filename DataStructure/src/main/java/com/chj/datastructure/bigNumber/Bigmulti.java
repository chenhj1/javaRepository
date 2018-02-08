package com.chj.datastructure.bigNumber;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Created by chenhaojie on 2018/02/08.
 * 大数相乘
 */
public class Bigmulti {
    public static void main(String []args){
        multi("999","99");
    }

    public static void multi(String a,String b){
        String ar = StringUtils.reverse(a);
        String br = StringUtils.reverse(b);

        int []aArray = new int[ar.length()];
        int []bArray = new int[br.length()];
        for(int i = 0;i<ar.length();i++){
            aArray[i] = Integer.parseInt(ar.charAt(i) + "");
        }
        for(int i = 0;i<br.length();i++){
            bArray[i] = Integer.parseInt(br.charAt(i) + "");
        }

        int []resultArr = new int[ar.length() + br.length()];//结果长度是两个数组长度和

        for(int i = 0;i<aArray.length;i++){
            for(int j = 0;j<bArray.length;j++){
                int total = resultArr[i+j]  + aArray[i] * bArray[j];//注意加上以前的进位！
                if(total > 9){
                    int high = total / 10;
                    int low = total % 10;
                    resultArr[i+j] = low;//当前位直接用low覆盖（low是经过以前的进位相加运算得出的，故直接覆盖）
                    resultArr[i+j+1] += high;//high还没有参与进位运算，所以要加上以前的high，不能直接覆盖。
                }else {
                    resultArr[i+j] = total;
                }

            }
        }

        ArrayUtils.reverse(resultArr);

        String result = "";
        for(int i = 0;i<resultArr.length;i++){
            result += String.valueOf(resultArr[i]);
        }

        result = StringUtils.removeStart(result,"0");
        System.out.println(result);
    }
}
