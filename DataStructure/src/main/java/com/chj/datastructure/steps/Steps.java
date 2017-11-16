package com.chj.datastructure.steps;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>或：</p>
 * 自动售卖机只能投入5角或1元硬币，买3元饮料有几种方法。
 */
public class Steps {

    public static void main(String []args){
        System.out.println(jumpFloor(15));
    }

    public static int jumpFloor(int number) {
        if (number == 5)
            return 1;
        else if (number == 10)
            return 2;
        else
            return jumpFloor(number-5)+jumpFloor(number-10);

    }

}
