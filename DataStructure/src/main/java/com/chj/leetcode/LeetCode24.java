package com.chj.leetcode;

/**
 * 两两交换链表节点。
 */
public class LeetCode24 {
    public static void main(String []args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node temp = swap(node1);
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private static class Node {
        int value;
        Node next;
        private Node(int v) {
            value = v;
        }
    }

    private static Node swap (Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node pre = dummy;
        Node curr = head;
        Node next = head.next;

        while (curr.next != null && curr.next.next != null) {
            curr.next = curr.next.next;
            next.next = curr;
            pre.next = next;

            pre = curr;
            curr = curr.next;
            next = curr.next;
        }

        return dummy.next;
    }

}
