package com.chj.leetcode;

import com.chj.datastructure.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 对称/镜像二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class LeetCode101 {

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public static boolean isJingxiangDiedai(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {

            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.getValue() != t2.getValue()) return false;

            q.add(t1.getLeft());
            q.add(t2.getRight());

            q.add(t1.getRight());
            q.add(t2.getLeft());
        }
        return true;
    }

    //----------------------------------------------------------------------------------------

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.value == t2.value)
                && isMirror(t1.getRight(), t2.left)
                && isMirror(t1.left, t2.right);
    }

}


