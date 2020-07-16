package com.chj.leetcode;

import java.util.Stack;

/**
 * 最大栈
 */
class LeetCode716 {
    // maintain stack to track all the data
    Stack<Integer> stack  =  new Stack<Integer>();
    // maintain maxStack to update current max
    Stack <Integer> maxStack  =  new Stack<Integer>();

    public void push(int x) {
        if (maxStack.isEmpty() || x >= maxStack.peek()){
            maxStack.push(x);
        }
        stack.push(x);
    }

    public int pop() {
        if (stack.peek().equals(maxStack.peek())){
            maxStack.pop();
        }
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        // maintain a tempStack to help convert data
        Stack <Integer> tempStack  =  new Stack<Integer>();

        int max  = maxStack.peek();
        // 1. push non-max item into tempStack
        while (!stack.peek().equals(maxStack.peek())){
            tempStack.push(stack.pop());
        }
        stack.pop();
        maxStack.pop();

        //2. directly use push() we wrote, pushing items back in both stack and tempStack
        while(!tempStack.isEmpty()){
            push(tempStack.pop());
        }
        return max;
    }


    public static void main(String[] args) {
        LeetCode716 s = new LeetCode716();
        s.push(9);
        s.push(8);
        s.push(7);
        s.push(6);

        System.out.println(s.popMax());
        System.out.println(s.popMax());
        System.out.println(s.popMax());
        System.out.println(s.popMax());



    }



}
