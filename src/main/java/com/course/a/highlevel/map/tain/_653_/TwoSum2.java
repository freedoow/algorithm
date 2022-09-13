package com.course.a.highlevel.map.tain._653_;

import java.util.HashMap;

/**
 * @author freed
 * @Description: 输入BTS数 哈希
 * @Date 2022-08-10
 */
public class TwoSum2 {
    public boolean findTarget(TreeNode root, int target) {
        if (root == null) return false;
        return find(root, target, new HashMap<>());
    }

    private boolean find(TreeNode node, int target, HashMap<Integer, Integer> map) {
        if (node == null) return false;

        if (map.containsKey(target - node.val)) return true;
        map.put(node.val, node.val);

        return find(node.right, target, map) || find(node.left, target, map);

    }

}
