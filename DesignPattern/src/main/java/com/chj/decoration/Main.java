package com.chj.decoration;

/**
 * 装饰者模式。
 *
 * 在不必改变原类文件和原类使用的继承的情况下，动态地扩展一个对象的功能。
 * 它是通过创建一个包装对象，也就是用装饰来包裹真实的对象来实现。
 * Created by chenhaojie on 2018/03/15.
 */
public class Main {
    public static void main(String[] args) {
        OldPersion old = new OldPersion();
        //old.eat();
        NewPersion np = new NewPersion(old);
        np.eat();
    }
}
