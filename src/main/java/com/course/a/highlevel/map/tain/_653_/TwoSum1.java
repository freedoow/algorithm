package com.course.a.highlevel.map.tain._653_;

import java.util.ArrayList;

/**
 * @author freed
 * @Description: 输入BTS数 二分
 * @Date 2022-08-10
 */
public class TwoSum1 {

    public boolean findTarget(TreeNode root, int target) {
        if (root == null) return false;
        ArrayList<Integer> nums = new ArrayList<>();
        //中序遍历
        inOrder(root, nums);
        //二分查找
        return binarySearch(target, nums);
    }

    //二分查找
    private boolean binarySearch(int target, ArrayList<Integer> nums) {
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == target) {
                return true;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    private void inOrder(TreeNode node, ArrayList<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        nums.add(node.val);
        inOrder(node.right, nums);
    }
}
