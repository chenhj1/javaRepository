package com.chj.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by chenhaojie on 2018/04/10.
 */
public class StudentDynamicProxy implements InvocationHandler {

    private Object object;

    public StudentDynamicProxy(Object student){
        this.object = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object,args);
        return null;
    }
}
