package com.chj.observer;

/**
 * 观察者模式<a href="http://www.yiibai.com/design_pattern/observer_pattern.html">链接</a><br>
 * 日间、夜间模式
 */
public class Main {

    public static void main(String []args){
        Subject subject = new Subject();

        Observer observer1 = new Observer1(subject);
        Observer observer2 = new Observer2(subject);

        subject.setMode(Mode.NIGHT);
    }
}
