package com.chj.observer;

/**
 * Created by chenhj1 on 2017/7/24.
 */
public class Observer2 extends Observer {

    private Subject subject;

    public Observer2(Subject subject){
        this.subject = subject;
        this.subject.addElement(this);
    }

    @Override
    public void update(int mode) {
        switch (mode){
            case Mode.DAY:
                System.out.println("Observer2日间模式");
                break;
            case Mode.NIGHT:
                System.out.println("Observer2夜间模式");
                break;
        }

    }
}
