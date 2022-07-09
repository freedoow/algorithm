package com.course.tree.blancesSeachTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author whb
 * @Description: 二叉查找树
 * @Date 2022-07-09
 */
public class Bstr<E extends Comparable> {
    private class TreeNode {
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode(E data) {
            this.data = data;
        }
    }

    private TreeNode root;
    private int size;

    public Bstr() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入操作
     **/
    public void add(E e) {
        root = add(root, e);
    }

    // 将节点E插入 node 节点的子树中
    // 返回插入节点后的二叉查找树的节点
    public TreeNode add(TreeNode node, E e) {

        // 1 递归终止条件
        if (node == null) {
            size++;
            return new TreeNode(e);
        }

        //2.递归调用
        if (e.compareTo(node.data) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 是否包含
     *
     * @param target
     * @return
     */
    public boolean contains(E target) {
        TreeNode treeNode = find(target);
        if (treeNode != null) return true;
        return false;
    }

    /**
     * 查找节点
     */
    public TreeNode find(E target) {
        if (root == null) return null;
        return find(root, target);
    }

    public TreeNode find(TreeNode node, E target) {
        int compareValue = target.compareTo(node.data);
        if (compareValue == 0) {
            return node;
        } else if (compareValue < 0) {
            return find(node.left, target);
        } else {
            return find(node.right, target);
        }
    }


    /**
     * 修改节点值
     */
    public void updateTarget(E target) {
        if (contains(target)) return;
        TreeNode treeNode = find(target);
        treeNode.data = target;
    }


    /**
     * 前序遍历
     */
    public List<E> preOrder() {
        ArrayList<E> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.data);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        return res;
    }

    /**
     * 中序遍历
     */
    public List<E> inOrder() {
        ArrayList<E> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.data);
            curr = curr.right;
        }
        return res;
    }

    /**
     * 后序遍历
     */
    public List<E> postOrder() {
        LinkedList<E> res = new LinkedList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.addFirst(curr.data);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        return res;
    }

    /**
     * 最小值
     */
    public E minValue() {
        if (root == null) throw new RuntimeException("tree is null");
        return minValue(root);
    }

    public E minValue(TreeNode node) {
        if (node.left == null) return node.data;
        return minValue(node.left);
    }

    /**
     * 最大值
     */
    public E maxValue() {
        if (root == null) throw new RuntimeException("tree is null");
        return maxValue(root);
    }

    public E maxValue(TreeNode node) {
        if (node.right == null) return node.data;
        return minValue(node.right);
    }


    // 删除操作

    /**
     * 删除最小值节点
     *
     * @return
     */
    public E removeMin() {
        if (root == null) throw new RuntimeException("tree is null");
        E res = minValue();
        removeMin();
        return res;
    }

    public TreeNode removeMin(TreeNode node) {
        //递
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        //归
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大值
     */

    public E removeMax() {
        if (root == null) throw new RuntimeException("tree is null");
        E res = maxValue();
        removeMax(root);
        return res;
    }

    public TreeNode removeMax(TreeNode node) {
        //递
        if (node.right == null) {
            TreeNode leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        //归
        node.right = removeMin(node.right);
        return node;
    }


    public void remove1(E e) {
        // 找到删除值
        if (root == null) throw new RuntimeException("tree is null");

        TreeNode curr = root;
        TreeNode parent = null;

        while (curr != null && e.compareTo(curr.data) != 0) {
            parent = curr;
            if (e.compareTo(curr.data) < 0) curr = curr.left;
            else curr = curr.right;
        }

        if (curr == null) return;

        if (curr.left != null && curr.right != null) {
            // 找到curr 的右子树的最小值节点
            TreeNode min = curr.right;
            TreeNode minParent = curr;
            while (min.left != null) {
                minParent = min;
                min = min.left;
            }
            // 覆盖需要删除节点的值为最小值
            curr.data = min.data;
            // 删除最小值
            curr = min;
            parent = minParent;
        }

        //删除叶子节点 & 仅有一个子树
        TreeNode child; // 用于储存 需要删除节点的子节点
        if (parent.left != null) {
            child = curr.left;
            if (parent != null) curr.left = null;
        } else if (parent.right != null) {
            child = curr.right;
            if (parent != null) curr.right = null;
        } else {
            child = null;
        }


        if (parent == null) {
            root = child;
        } else if (curr == parent.left) {
            parent.left = child;
        } else if (curr == parent.right) {
            parent.right = child;
        }
    }

    /**
     * 删除任意节点
     */
    public void remove(E e) {
        if (root == null) throw new RuntimeException("tree is null");

        TreeNode curr = root;
        TreeNode parent = null;

        while (curr != null && e.compareTo(curr.data) != 0) {
            parent = curr;
            if (e.compareTo(curr.data) < 0) curr = curr.left;
            else curr = curr.right;
        }

        if (curr == null) return;


        if (curr.left == null && curr.right == null) { // 删除叶子节点
            if (parent == null) root = null;
            if (curr == parent.left) parent.left = null;
            if (curr == parent.right) parent.right = null;
        } else if (curr.left != null && curr.right == null) { // 删除只有左子树

            if (parent == null) {
                root = curr.left;
            } else if (curr == parent.left) {
                parent.left = curr.left;
                curr.left = null;
            } else if (curr == parent.right) {
                parent.right = curr.left;
                curr.left = null;
            }

        } else if (curr.right != null && curr.left == null) { // 删除只有右子树

            if (parent == null) {
                root = curr.right;
            } else if (curr == parent.left) {
                parent.left = curr.right;
                curr.right = null;
            } else if (curr == parent.right) {
                parent.right = curr.right;
                curr.right = null;
            }

        } else if (curr.left != null && curr.right != null) {
            // 找到curr 的右子树的最小值节点
            TreeNode min = curr.right;
            TreeNode minParent = curr;
            while (min.left != null) {
                minParent = min;
                min = min.left;
            }
            // 覆盖需要删除节点的值为最小值
            curr.data = min.data;
            // 删除最小值
            minParent.left = null;


        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "AAAA%s";
        System.out.println(String.format(s, "123"));
    }

}
