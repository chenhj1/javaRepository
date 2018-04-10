package com.chj.proxy.staticProxy;

/**
 * Created by chenhaojie on 2018/04/10.
 */
public class Main {
    public static void main(String []args){
        Student zhangsan = new CommonStudent("张三");
        Student monitor = new StudentProxy(zhangsan);

        monitor.giveMoney();//班长代缴费
    }
}
