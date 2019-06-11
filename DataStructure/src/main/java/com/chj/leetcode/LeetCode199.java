package com.chj.leetcode;

import com.chj.datastructure.Tree.TreeNode;
import com.chj.datastructure.Tree.TreeTraversal;

import java.util.*;

/**
 * 输出二叉树每一行最右边节点的值
 * 二叉树的右视图
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class LeetCode199 {

    public static void main(String []args) {
        TreeNode root = TreeTraversal.createTree();
        System.out.println(fun(root));
    }

    public static List<Integer> fun (TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode last = root;       // 当前行的最后一个节点
        TreeNode nextLast = root;   // 下一行的最后一个节点

        while (!q.isEmpty()) {
            TreeNode n = q.poll();

            if (n.left != null) {
                q.add(n.left);
                nextLast = n.left;  // 每加入一个节点，都把nextLast变成那个节点
            }

            if (n.right != null) {
                q.add(n.right);
                nextLast = n.right; // 每加入一个节点，都把nextLast变成那个节点
            }

            if (n == last) {
                resultList.add(n.value);
                last = nextLast;
            }

        }
        return resultList;

    }
}
