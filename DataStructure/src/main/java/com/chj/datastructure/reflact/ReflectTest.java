package com.chj.datastructure.reflact;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;

/**
 * 反射
 * Created by chenhaojie on 2017/11/21.
 */
public class ReflectTest {

    public static void main(String []args){

        try {
            Class c = Class.forName("com.chj.datastructure.reflact.Car");
            Method m = c.getMethod("sayHello",String.class);
            m.invoke(c.newInstance(),"hello");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
