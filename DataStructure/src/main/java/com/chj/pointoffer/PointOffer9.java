package com.chj.pointoffer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 两个栈实现队列。
 * 主要思路是找规律。
 */
public class PointOffer9 {
    @Test
    public void solution() {
        MyStack s = new MyStack();
        s.add(1);
        s.add(2);
        System.out.println(s.poll());
        s.add(3);
        s.add(4);
        System.out.println(s.poll());
        s.add(5);
        System.out.println(s.poll());
        System.out.println(s.poll());
        System.out.println(s.poll());
    }

    class MyStack{
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        public void add(int item){
            if (!q1.isEmpty()) {
                q1.add(item);
            }else if(!q2.isEmpty()) {
                q2.add(item);
            } else {
                q1.add(item);
            }
        }

        public int poll() {
            if (!q1.isEmpty()){
                while (!q1.isEmpty()){
                    q2.add(q1.poll());
                }
                return q2.poll();
            }else if (!q2.isEmpty()){
                while (!q2.isEmpty()){
                    q1.add(q2.poll());
                }
                return q1.poll();
            }
            return -1;
        }

    }
}
