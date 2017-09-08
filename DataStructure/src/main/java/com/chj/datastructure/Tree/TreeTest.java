package com.chj.datastructure.Tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chenhj1 on 2017/8/2.
 */
public class TreeTest {


    /**
     *                  8
     *                 /  \
     *               3     5
     *              /  \    \
     *             2   9     7
     */
    public static TreeNode createTree() {
        TreeNode root = new TreeNode(8);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node9 = new TreeNode(9);
        TreeNode node7 = new TreeNode(7);

        root.setLeft(node3);
        root.setRight(node5);
        node3.setLeft(node2);
        node3.setRight(node9);
        node5.setRight(node7);

        return root;
    }

    /**
     * 广度优先遍历
     */
    @Test
    public void levelOrder() {
        TreeNode root = createTree();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);                      //先把root节点从队列头加入。
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();         //从队列尾取出节点。
                System.out.print(node.getValue() + ",  ");//访问该节点。

                //若左右子树不为空，加入队列。注意顺序。
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }
    }


    /**
     * 深度优先遍历
     */
    @Test
    public void depthOrder(){
        TreeNode root = createTree();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            System.out.print(node.getValue()+"    ");
            if(node.getRight()!=null){
                stack.push(node.getRight());
            }

            if(node.getLeft()!=null){
                stack.push(node.getLeft());
            }
        }
    }
}
