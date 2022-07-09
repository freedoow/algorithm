package com.course.tree.binarytree.tain;

/**
 * @author fd
 * @Description:
 * @Date 2022-05-05
 */
public class TreeNode<E> {
    int val;
    TreeNode<E> left;
    TreeNode<E> right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
