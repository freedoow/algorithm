package com.course.a.tree.binarytree.tain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author whb
 * @Description: 对称二叉树
 * @Date 2022-06-08
 */
public class _101_SymmetricTree {

    //BFS
    public Boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode t1 = queue.peek();
            TreeNode t2 = queue.peek();
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }

        return true;
    }

    //DFS
    public Boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private Boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);

    }
}
