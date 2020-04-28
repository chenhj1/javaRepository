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
     *                     1
     *                 /       \
     *               2          3
     *              /  \       /  \
     *             4   5      6    7
     *            /     \   /  \
     *           8      9  10  11
     */
    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);

        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node4.setLeft(node8);
        node4.setRight(node9);

        node5.setLeft(node10);
        node5.setRight(node11);

        return root;
    }

    /**
     * 寻找最长路径的长度。
     */
    public static int maxLength;
    public static void longestPath(TreeNode root,int currLength){
        if (root.getLeft() != null){
            longestPath(root.getLeft(),currLength + 1);
        }
        if(root.getRight() != null){
            longestPath(root.getRight(),currLength + 1);
        }
        if(root.getRight() == null && root.getLeft() == null){
            if (currLength > maxLength){
                maxLength = currLength;
            }
        }
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
            int queueSize = queue.size();

            TreeNode node = queue.poll();
            int temp = node.getValue();
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }


            for (int i = 1; i < queueSize; i++) {
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
     * 输出二叉树每一行最大值 V2写法
     */
    @Test
    public void  largestValuesV2() {
        TreeNode root = createTree();
        Queue<TreeNode> queue = new ArrayDeque<>();

        List<Integer> results = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();  // 记录当前这一层的元素个数。下方的“遍历一层”，遍历到queueSize截止
            int max = Integer.MIN_VALUE;

            // 遍历一层。
            for (int i = 0; i < queueSize; i++) {  // 遍历这一层找出最大值。同时把这一层的所有孩子节点放入队列中。
                TreeNode node = queue.poll();
                if (node.value > max) max = node.value;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            results.add(max);
        }
        System.out.println(ArrayUtils.toString(results));
    }

    /**
     * 层次打印二叉树
     */
    @Test
    public void  treePrint() {
        TreeNode root = createTree();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();  // 记录当前这一层的元素个数。

            // 遍历一层。每次循环打印这一层的一个节点，同时把该节点的左右子节点放入队列。
            //由于这个循环执行queueSize次，所以打印完本层节点就结束for循环了。孩子节点会在下一轮while循环打印。
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.value + " ");

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            System.out.println();
        }
    }

    /**
     * 蛇形打印二叉树。
     * 思路：定义一个二维结果数组，按照“分层打印”的思路，判断当前是奇数偶数层，决定当前层数组元素的顺序。
     */
    @Test
    public void  treePrintZ() {
        TreeNode root = createTree();
        Queue<TreeNode> queue = new ArrayDeque<>();
        LinkedList<LinkedList<TreeNode>> results = new LinkedList<LinkedList<TreeNode>>();  // 结果（二维数组）
        boolean flag = true;

        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();  // 记录当前这一层的元素个数。

            LinkedList<TreeNode> oneLevelResult = new LinkedList<TreeNode>();  // 保存本层节点

            // 遍历一层。每次循环打印这一层的一个节点，同时把该节点的左右子节点放入队列。
            //由于这个循环执行queueSize次，所以打印完本层节点就结束for循环了。孩子节点会在下一轮while循环打印。
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                // 判断奇偶层，决定本层节点是正序还是逆序保存
                if (flag) {
                    oneLevelResult.addLast(node);
                }else {
                    oneLevelResult.addFirst(node);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            results.add(oneLevelResult);
            flag = !flag;
        }

        // 输出结果
        for (int i = 0;i<results.size();i ++ ){
            LinkedList<TreeNode> oneLevelResult = results.get(i);
            for (int j = 0;j<oneLevelResult.size();j ++ ){
                System.out.print(oneLevelResult.get(j).value + " ");
            }
            System.out.println("");
        }
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
//        System.out.println(leafNum(root));
        longestPath(root,1);
        System.out.println(maxLength);
    }

}
