package com.chj.datastructure.bigfile;

/**
 * Created by Administrator on 2017/8/14.
 */
public class BigFileTest {
    public static void main(String []args){
        BigFileReader bigFileReader = new BigFileReader.Builder("E:\\javafile\\bigfile.txt", new IHandle() {
            @Override
            public void handle(String line) {
                System.out.println(line);
            }
        }).build();
        bigFileReader.start(bigFileReader);
    }
}
