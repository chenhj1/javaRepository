package com.chj.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenhj1 on 2017/7/24.
 */
public class Subject {

    public static List<Observer>list = new LinkedList<>();

    public static int mode;

    public void addElement(Observer observer){
        list.add(observer);
    }

    public void notifyAllElements(int mode){
        switch (mode){
            case Mode.DAY:
                for (Observer observer:list){
                    observer.update(Mode.DAY);
                }
                break;
            case Mode.NIGHT:
                for (Observer observer:list){
                    observer.update(Mode.NIGHT);
                }
                break;
        }

    }

    public void setMode(int mode){
        this.mode = mode;
        notifyAllElements(mode);
    }
}
