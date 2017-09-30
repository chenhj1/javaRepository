package com.chj.datastructure.NodeList;

/**
 * 链表反转
 * Created by chenhaojie on 2017/09/30.
 */
public class NodeListTest {

    public static void main(String[] args) {

        //循环
        Node head1 = init(10);
        out(head1);
        Node reversedHead1 = reverseHead(head1);
        out(reversedHead1);

        //递归
        Node head2 = init(10);
        out(head2);
        Node reversedHead2 = reverseByRecur(head2);
        out(reversedHead2);

    }

    /**
     * 反转单链表
     * @param head
     * @return
     */
    private static Node reverseHead(Node head) {
        if (head == null) {
            return head;
        }

        Node pre = head;
        Node cur = head.nextNode;
        Node next = null;
        while(cur != null){
            next = cur.nextNode;
            cur.nextNode = pre;

            pre = cur;
            cur = next;
        }
        head.nextNode = null;
        head = pre;
        return head;
    }

    /**
     * 递归反转
     * @param current
     * @return
     */
    private static Node reverseByRecur(Node current) {
        if (current == null || current.nextNode == null) return current;
        Node nextNode = current.nextNode;
        current.nextNode = null;
        Node reverseRest = reverseByRecur(nextNode);
        nextNode.nextNode = current;
        return reverseRest;
    }

    /**
     * 初始化单链表
     *
     * @param num 数量
     * @return
     */
    public static Node init(int num) {
        Node head = new Node(0, null);
        Node cur = null;
        Node temp = null;
        for (int i = 1; i < num; i++) {
            temp = new Node(i, null);
            if (i == 1) {
                head.nextNode = temp;
            } else {
                cur.nextNode = temp;
            }
            cur = temp;
        }
        return head;
    }

    /**
     * 打印节点值
     *
     * @param head
     */
    private static void out(Node head) {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }

}
