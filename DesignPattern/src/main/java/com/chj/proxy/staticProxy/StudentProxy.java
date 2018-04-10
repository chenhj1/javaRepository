package com.chj.proxy.staticProxy;

/**
 * Created by chenhaojie on 2018/04/10.
 */
public class StudentProxy implements Student {
    private Student student;

    public StudentProxy(Student student){
        this.student = student;
    }

    /**
     * 班长代替commonStudent缴费
     */
    @Override
    public void giveMoney() {
        student.giveMoney();
    }
}
