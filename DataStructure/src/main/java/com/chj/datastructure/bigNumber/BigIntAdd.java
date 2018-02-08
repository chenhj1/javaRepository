package com.chj.datastructure.bigNumber;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Created by chenhaojie on 2018/02/08.
 * 大数相加。
 */
public class BigIntAdd {
    public static void main(String []args){
//        add("34725","2564");
        add("9999","100001");
    }

    public static void add(String a,String b){
        //自字符串转置
        String av = StringUtils.reverse(a);
        String bv = StringUtils.reverse(b);

        //构建转置后的int数组
        int []aArray = new int[av.length()];
        int []bArray = new int[bv.length()];
        for(int i = 0;i<av.length();i++){
            aArray[i] = Integer.parseInt(av.charAt(i) + "");
        }
        for(int i = 0;i<bv.length();i++){
            bArray[i] = Integer.parseInt(bv.charAt(i) + "");
        }

        int length = aArray.length>bArray.length?aArray.length:bArray.length;
        int [] resultArr = new int[length + 1];
        for(int i = 0;i < length;i++){
            int aint = 0;
            int bint = 0;
            if(i < aArray.length){
                aint = aArray[i];
            }
            if(i < bArray.length){
                bint = bArray[i];
            }

            int total = resultArr[i] + aint + bint;//注意加上以前的进位！
            if(total > 9){
                int high = total / 10;
                int low = total % 10;
                resultArr[i] = low;//当前位直接用low覆盖（low是经过以前的进位相加运算得出的，故直接覆盖）
                resultArr[i+1] += high;//high还没有参与进位运算，所以要加上以前的high，不能直接覆盖。
            }else {
                resultArr[i] = total;
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
