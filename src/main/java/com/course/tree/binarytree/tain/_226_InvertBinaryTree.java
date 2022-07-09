package com.course.tree.binarytree.tain;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 *
 * TreeNode temp = curr.left;
 * curr.left = curr.right;
 * curr.right = temp;
 *
 * @author freedoow
 * @Description:
 * @Date 2022-05-31
 */
public class _226_InvertBinaryTree {

    //BFS
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return root;
    }

    //递归
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;

        invertTree1(root.left);
        invertTree1(root.right);


        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    // DFS
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        return root;
    }
}
