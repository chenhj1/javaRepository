package com.ifeng.observer;

/**
 * Created by chenhj1 on 2017/7/24.
 */
public class Observer1 extends Observer {

    private Subject subject;

    public Observer1(Subject subject){
        this.subject = subject;
        this.subject.addElement(this);
    }

    @Override
    public void update(int mode) {
        switch (mode){
            case Mode.DAY:
                System.out.println("Observer1日间模式");
                break;
            case Mode.NIGHT:
                System.out.println("Observer1夜间模式");
                break;
        }

    }
}
