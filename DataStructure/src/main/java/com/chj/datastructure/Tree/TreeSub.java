package com.chj.datastructure.Tree;

import java.util.Stack;

/**
 * 查找二叉树和为某个值的所有路径
 * <p>
 * Created by chenhaojie on 2018/06/05.
 */
public class TreeSub {

    /**
     * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶销点所经过的结点形成一条路径。
     *
     * @param root        树的根结点
     * @param expectedSum 要求的路径和
     */
    public static void findPath(TreeNode root, int expectedSum) {
        // 用于存放根结点到当前处理结点的所经过的结点
        Stack<Integer> stack = new Stack<>();
        // 如果根结点不为空，就调用辅助处理方法
        if (root != null) {
            findPath(root, 0, expectedSum, stack);
        }
    }

    /**
     * @param root        当前要处理的结点
     * @param curSum      当前记录的和（还未加上当前结点的值）
     * @param expectedSum 要求的路径和
     * @param stack      根结点到当前处理结点的所经过的结点，（还未包括当前结点）
     */
    public static void findPath(TreeNode root, int curSum, int expectedSum, Stack<Integer> stack) {
        // 如果结点不为空就进行处理
        if (root != null) {
            // 加上当前结点的值
            curSum += root.getValue();
            // 将当前结点值入栈
            stack.add(root.getValue());
            // 如果当前结点的值小于期望的和
            if (curSum < expectedSum) {
                // 递归处理左子树
                findPath(root.getLeft(), curSum, expectedSum, stack);
                // 递归处理右子树
                findPath(root.getRight(), curSum, expectedSum, stack);
            } else if (curSum == expectedSum) {  // 如果当前和与期望的和相等
                if (root.getLeft() == null && root.getRight() == null) { // 当前结点是叶结点，则输出结果
                    System.out.println(stack);
                }
            }
            // 当前节点值出栈
            stack.pop();
        }
    }

    /**
     *                  8
     *                 /  \
     *               3     5
     *              /  \    \
     *             2   9     7
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = TreeTraversal.createTree();
        findPath(root, 20);
    }
}
