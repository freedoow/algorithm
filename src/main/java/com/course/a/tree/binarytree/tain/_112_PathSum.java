package com.course.a.tree.binarytree.tain;

import java.util.Stack;

/**
 * @author whb
 * @Description:
 * @Date 2022-05-24
 */
public class _112_PathSum {
    private class Node {
        TreeNode node; //当前树节点
        int pathSum; // 跟节点到当前节点的路径和

        public Node(TreeNode node, int pathSum) {
            this.node = node;
            this.pathSum = pathSum;
        }
    }


    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;

        sum = sum - root.val;

        if (root.left == null && root.right == null) return sum == 0;

        boolean hasPathLeft = hasPathSum(root.left, sum - root.val);
        boolean hasPathRight = hasPathSum(root.right, sum - root.val);

        return hasPathLeft || hasPathRight;
    }

    // remainSum
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;


        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, sum - root.val));

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            TreeNode currNode = node.node;
            int currPathSum = node.pathSum;

            if (currNode.left == null && currNode.right == null && currPathSum == 0) return true;

            if (currNode.left != null) stack.push(new Node(currNode.left, currPathSum - currNode.left.val));
            if (currNode.right != null) stack.push(new Node(currNode.right, currPathSum - currNode.right.val));
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;


        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, root.val));

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            TreeNode currNode = node.node;
            int currPathSum = node.pathSum;

            if (currNode.left == null && currNode.right == null && currPathSum == sum) return true;

            if (currNode.left != null) stack.push(new Node(currNode.left, currPathSum + currNode.left.val));
            if (currNode.right != null) stack.push(new Node(currNode.right, currPathSum + currNode.right.val));
        }
        return false;
    }
}
