package com.chj.datastructure.StackQueue;

import java.util.Stack;

/**
 *
 * <a href="http://blog.csdn.net/scgaliguodong123_/article/details/48175183">两个栈实现队列</a><p></p>
 * Created by chenhaojie on 2018/01/10.
 */
public class MyQueue {
    private Stack<Integer>stack1 = new Stack<>();
    private Stack<Integer>stack2 = new Stack<>();

    public void push(int value){
        stack1.push(value);
    }

    public int pop() throws Exception{

        if(stack2.size() == 0){
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
        }

        if(stack2.size() == 0)
            throw new Exception("Queue is empty");

        return stack2.pop();
    }

    public static void main (String []args)throws Exception{
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}
