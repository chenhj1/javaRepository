package com.chj.proxy.staticProxy;

/**
 * Created by chenhaojie on 2018/04/10.
 */
public class CommonStudent implements Student {

    private String name;

    public CommonStudent(String name){
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println("学生 " + name + " 上缴班费");
    }
}
