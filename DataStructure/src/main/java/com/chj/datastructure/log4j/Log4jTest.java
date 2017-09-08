package com.chj.datastructure.log4j;

import org.apache.log4j.Logger;

/**
 * Created by chenhj1 on 2017/8/22.
 */
public class Log4jTest {

    private static Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String []args){
        logger.info("test");
    }
}
