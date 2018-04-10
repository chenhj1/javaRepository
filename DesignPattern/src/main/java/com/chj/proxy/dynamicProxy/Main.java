package com.chj.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by chenhaojie on 2018/04/10.
 */
public class Main {
    public static void main(String []args){
        Student zhangsan = new CommonStudent("zhangsan");
        InvocationHandler stuHandler = new StudentDynamicProxy(zhangsan);

        Student monitor = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(),new Class<?>[]{Student.class},stuHandler);

        monitor.giveMoney(25);
    }
}
