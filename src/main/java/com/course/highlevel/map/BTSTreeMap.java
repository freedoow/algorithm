package com.course.highlevel.map;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-04
 */
public class BTSTreeMap<K extends Comparable, V> implements Map<K, V> {
    private TreeNode root;
    private int size;

    public BTSTreeMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private TreeNode<K, V> add(TreeNode<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new TreeNode<>(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            node.right = add(node.right, key, value);
        }

        return node;
    }

    @Override
    public V remove(K key) {
        TreeNode<K, V> node = get(root, key);
        if (node == null) return null;
        root = remove(root, key);
        return node.value;
    }

    private TreeNode<K, V> remove(TreeNode<K, V> node, K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                size--;
                return left;
            }

            TreeNode minNode = minValue(node.right);
            minNode.right = removeMin(minNode);
            minNode.left = node.left;

            node.left = null;
            node.right = null;
            size--;
            return minNode;

        }
    }

    private TreeNode<K, V> minValue(TreeNode<K, V> node) {
        if (node.left == null) return node;
        return minValue(node.left);
    }

    private TreeNode<K, V> removeMin(TreeNode<K, V> node) {
        if (node.left == null) {
            TreeNode<K, V> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        TreeNode leftNode = removeMin(node.left);
        node.left = leftNode;
        return node;
    }

    @Override
    public void set(K key, V newValue) {
        TreeNode<K, V> node = get(root, key);
        if (node != null) node.value = newValue;

    }

    @Override
    public V get(K key) {
        TreeNode<K, V> node = get(root, key);
        return node == null ? null : node.value;
    }

    private TreeNode<K, V> get(TreeNode<K, V> node, K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) > 0) {
            return get(node.right, key);
        } else {
            return get(node.left, key);
        }
    }

    @Override
    public boolean containsKey(K key) {
        TreeNode node = get(root, key);
        return node != null;
    }
}
