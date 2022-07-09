package com.course.tree.binarytree;

import java.util.*;

/**
 * @author whb
 * @Description:
 * @Date 2022-05-05
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(23);
        TreeNode<Integer> node1 = new TreeNode<>(34);
        TreeNode<Integer> node2 = new TreeNode<>(21);
        TreeNode<Integer> node3 = new TreeNode<>(99);
        TreeNode<Integer> node4 = new TreeNode<>(77);
        TreeNode<Integer> node5 = new TreeNode<>(90);
        TreeNode<Integer> node6 = new TreeNode<>(45);
        TreeNode<Integer> node7 = new TreeNode<>(60);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node6;
        node2.right = node7;

        System.out.println(root.toString());
        System.out.println(preOrder(root).toString());
    }

    //前序遍历
    public static ArrayList<Integer> preOrder(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            res.add(curr.data);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return res;
    }

    //中序遍历
    public static ArrayList<Integer> inOrder(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = root;
        while (curr != null && !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode<Integer> node = stack.pop();
            res.add(node.data);

            curr = node.right;
        }
        return res;
    }

    //后序遍历
    public static ArrayList<Integer> postOrder(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            res.add(curr.data);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        Collections.reverse(res);
        return res;
    }


    public static List<Integer> postOrder1(TreeNode<Integer> root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            res.addFirst(curr.data);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        return res;
    }

    //层序遍历
    public static List<Integer> levelOrder(TreeNode<Integer> root) {
        if (root == null) return new ArrayList<>(0);
        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        if (!queue.isEmpty()) {
            //每轮循环遍历一个节点
            TreeNode<Integer> curr = queue.poll();
            list.add(curr.data);
            //处理的节点左右子节点入队，等候处理
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return list;
    }

    public static List<List<Integer>> levelOrder1(TreeNode<Integer> root) {
        if (root == null) return new ArrayList<>(0);
        ArrayList<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        if (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                //每轮循环遍历一个节点
                TreeNode<Integer> curr = queue.poll();
                levelList.add(curr.data);
                //处理的节点左右子节点入队，等候处理
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            list.add(levelList);
        }
        return list;
    }

    public static ArrayList<Integer> preOrderR(TreeNode<Integer> root) {
        if (root == null) return new ArrayList<>(0);

        ArrayList<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private static void preOrder(TreeNode<Integer> node, List<Integer> list) {
        if (node == null) return;
        list.add(node.data);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    public static ArrayList<Integer> inOrderR(TreeNode<Integer> root) {
        if (root == null) return new ArrayList<>(0);

        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private static void inOrder(TreeNode<Integer> node, List<Integer> list) {
        if (node == null) return;
        preOrder(node.left, list);
        list.add(node.data);
        preOrder(node.right, list);
    }

    public static ArrayList<Integer> postOrderR(TreeNode<Integer> root) {
        if (root == null) return new ArrayList<>(0);

        ArrayList<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private static void postOrder(TreeNode<Integer> node, List<Integer> list) {
        if (node == null) return;
        preOrder(node.left, list);
        preOrder(node.right, list);
        list.add(node.data);
    }

}
