package com.course.a.highlevel.map;

/**
 * @author freed
 * @Description:
 * @Date 2022-07-30
 */
public class TreeNode<K, V> {
    K key;
    V value;
    TreeNode left;
    TreeNode right;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }


}
