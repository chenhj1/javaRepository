package com.chj.datastructure.bigfile;

/**
 * Created by Administrator on 2017/8/14.
 */
public class BigFileTest {

    public static final String filepath = "C:\\data\\bigfile.txt";

    public static void main(String []args){
        BigFileReader bigFileReader = new BigFileReader.Builder(filepath, new IHandle() {
            @Override
            public void handle(String line) {
                System.out.println(line);
            }
        }).withTreahdSize(2).withCharset("UTF-8").build();
        bigFileReader.start();
    }
}
