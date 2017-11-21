package com.chj.datastructure.reflact;

/**
 * Created by chenhaojie on 2017/11/21.
 */
public class Car {

    private String name;
    private String color;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void sayHello(String s){
        System.out.println(s);
    }

}
