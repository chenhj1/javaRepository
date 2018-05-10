package com.chj.datastructure.Tree;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.util.*;

/**
 * Created by chenhj1 on 2017/8/2.
 * <a href="http://blog.csdn.net/my_jobs/article/details/43451187">二叉树遍历</a>
 * 对于二叉树，有深度遍历和广度遍历，深度遍历有前序、中序以及后序三种遍历方法，广度遍历即我们平常所说的层次遍历。
 */
public class TreeTraversal {


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
     * 广度优先遍历。循环
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
     * 输出二叉树每一行最大值
     */
    @Test
    public void  largestValues() {
        TreeNode root = createTree();
        Queue<TreeNode> queue = new ArrayDeque<>();

        List<Integer> res = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();

            TreeNode node = queue.poll();
            int temp = node.getValue();
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }


            for (int i = 1; i < levelNum; i++) {
                if (queue.peek().getValue() > temp) {
                    temp = queue.peek().getValue();
                }
                if (queue.peek().getLeft() != null) {
                    queue.add(queue.peek().getLeft());
                }
                if (queue.peek().getRight() != null){
                    queue.add(queue.peek().getRight());
                }
                queue.remove();
            }
            res.add(temp);
        }
        System.out.println(ArrayUtils.toString(res));
    }


    /**
     * 深度优先遍历。循环
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

    /**
     * 深度优先遍历。前序。递归。
     * @param root
     */
    public static void levelPreOrder(TreeNode root){
        if (root != null) {
            System.out.print(root.getValue()+"  ");
            levelPreOrder(root.getLeft());
            levelPreOrder(root.getRight());
        }
    }

    /**
     * 二叉树的深度。递归。
     */
    public static int deep(TreeNode node) {
        int leftHight, rightHight;
        if (node == null) {
            return 0;
        } else {
            leftHight = deep(node.getLeft());
            rightHight = deep(node.getRight());
            return (leftHight < rightHight) ? rightHight + 1 : leftHight + 1;
        }
    }

    /**
     * 叶子数
     * @param node
     * @return
     */
    public static int leafNum(TreeNode node) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                return 1;
            }
            return leafNum(node.getLeft()) + leafNum(node.getRight());
        }
        return 0;
    }

    public static void main(String []args){
        TreeNode root = createTree();
//        levelPreOrder(root);
//        System.out.println(deep(root));
        System.out.println(leafNum(root));
    }

}
