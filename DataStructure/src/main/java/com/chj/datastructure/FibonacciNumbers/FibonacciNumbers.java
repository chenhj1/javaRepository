package com.chj.datastructure.FibonacciNumbers;

/**
 * Created by chenhaojie on 2018/02/09.
 * 菲波那切数列
 */
public class FibonacciNumbers {

    public static void main(String []args){
        System.out.println(fn(6));
    }

    public static int fn(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        return fn(n-1) + fn(n-2);
    }

}
