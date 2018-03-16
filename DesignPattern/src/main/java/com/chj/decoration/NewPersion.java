package com.chj.decoration;

/**
 * Created by chenhaojie on 2018/03/15.
 */
public class NewPersion implements Persion{
    private OldPersion p;

    public NewPersion(OldPersion p) {
        this.p = p;
    }

    @Override
    public void eat() {
        System.out.println("我是社会主义接班人，我还会 生火");
        System.out.println("我是社会主义接班人，我还会 做饭");
        p.eat();
        System.out.println("我是社会主义接班人，我还会 刷碗");
    }

}
