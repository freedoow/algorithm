package com.course.a.tree.binarytree.tain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author whb
 * @Description:
 * @Date 2022-06-05
 */
public class _100_SameTree {


    //BFS 迭代
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q == null) return false;
        if (p.val != q.val) return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);

        if (!(queue1.isEmpty() && queue2.isEmpty())) {
            TreeNode peek1 = queue1.peek();
            TreeNode peek2 = queue2.peek();
            if (peek1.val != peek2.val) return false;

            TreeNode left1 = peek1.left;
            TreeNode right1 = peek1.right;
            TreeNode left2 = peek2.left;
            TreeNode right2 = peek2.right;


            if (left1 == null ^ left2 == null) return false;
            if (right1 == null ^ right2 == null) return false;

            if (left1 != null) queue1.offer(left1);
            if (right1 != null) queue1.offer(right1);
            if (left2 != null) queue2.offer(left2);
            if (right2 != null) queue2.offer(right2);

        }
        return queue1.isEmpty() && queue2.isEmpty();


    }


    //DFS 递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
