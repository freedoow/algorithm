package com.course.a.tree.binarytree.tain;


import java.util.*;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-05-11
 */
public class _104_MaximumDepthOfBinaryTree {
    public class Node {
        TreeNode<Integer> node;
        int depth;

        public Node(TreeNode<Integer> node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    //DFS
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDepth = maxDepth2(root.left);
        int rightMaxDepth = maxDepth2(root.right);
        int maxDepth = Math.max(leftMaxDepth, rightMaxDepth) + 1;
        return maxDepth;
    }

    // BFS 广度优先搜索
    public int maxDepth1(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        if (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                //每轮循环遍历一个节点
                TreeNode<Integer> curr = queue.poll();
                //处理的节点左右子节点入队，等候处理
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            depth += 1;
        }
        return depth;
    }

    //前序遍历 DFS 深度优先搜索
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = 0;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(root, 1));
        while (!stack.isEmpty()) {
            Node currNode = stack.pop();
            TreeNode<Integer> node = currNode.node;
            int currDepth = currNode.depth;
            maxDepth = Math.max(maxDepth, currDepth);

            if (node.right != null) stack.push(new Node(node.right, maxDepth + 1));
            if (node.left != null) stack.push(new Node(node.left, maxDepth + 1));
        }
        return maxDepth;
    }
}
