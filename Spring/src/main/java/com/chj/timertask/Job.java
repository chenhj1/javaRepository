package com.chj.timertask;

import com.chj.util.DateUtil;
import org.junit.Test;

/**
 * 定时任务<br>
 * <a href="http://www.jianshu.com/p/25c601f43552">定时任务</a>
 *
 */
public class Job {


    /**
     * 执行定时任务的方法
     */
    public void jobMethod(){
        System.out.println("***********************************");
        System.out.println("*                                 *");
        System.out.println("*                                 *");
        System.out.println("*         Timer Job Start         *");
        System.out.println("*       " + DateUtil.getDate() + "       *");
        System.out.println("*                                 *");
        System.out.println("*                                 *");
        System.out.println("***********************************");
    }

}
