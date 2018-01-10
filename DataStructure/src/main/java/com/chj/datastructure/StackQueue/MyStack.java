package com.chj.datastructure.StackQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="http://blog.csdn.net/scgaliguodong123_/article/details/48175183">两个队列实现栈</a><p></p>
 * Created by chenhaojie on 2018/01/10.
 */
public class MyStack {
    private Queue<Integer>queue1 = new ArrayDeque();
    private Queue<Integer>queue2 = new ArrayDeque();

    public void add(int value){
        if(queue1.size() == 0 && queue2.size() == 0)
            queue1.add(value);

        if(queue1.size() > 0){
            queue1.add(value);
        }else {
            queue2.add(value);
        }
    }

    public int poll()throws Exception{
        if(queue1.size() >= 1){
            while (queue1.size() > 1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }

        if(queue2.size() >= 1){
            while (queue2.size() > 1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }

        throw new Exception("Stack is null!");
    }


    public static void main(String []args)throws Exception{
        MyStack myStack = new MyStack();
        myStack.add(1);
        myStack.add(2);
        System.out.println(myStack.poll());
        myStack.add(3);
        myStack.add(4);
        myStack.add(5);
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
    }
}
