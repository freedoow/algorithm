package com.course.tree.redBlack;

import com.sun.org.apache.bcel.internal.generic.FADD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author whb
 * @Description: AVL
 * @Date 2022-07-10
 */
public class redBlackTree<E extends Comparable> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class TreeNode {
        E data;
        TreeNode left;
        TreeNode right;
        int height = 1;
        boolean color;

        public TreeNode(E data) {
            this.data = data;
            //1、红黑树中，红色节点代表的就是它和它的父亲在2-3树中是融合在一起的
            //2、在2-3树中 插入新建节点时候，都是先和叶子节点进行融合
            this.color = RED;
        }
    }

    private TreeNode root;
    private int size;

    public redBlackTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //节点是否为红色
    private boolean isRED(TreeNode node) {
        // 根据红黑树定义，空节点的颜色是黑色
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    //计算高度
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return node.height;
    }

    //计算平衡因子
    private int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        //平衡因子等于左右节点的高度差
        return getHeight(node.left) - getHeight(node.right);
    }

    //是否是二叉查找树
    public boolean isBST() {
        List<E> res = inOrder();
        int len = res.size();
        if (len <= 1) return true;

        for (int i = 1; i < len; i++) {
            if (res.get(i).compareTo(res.get(i - 1)) < 0) return false;
        }
        return true;
    }

    //二叉查找树是否平衡
    public boolean isBalanced() {
        return isBalanced(root);
    }

    public boolean isBalanced(TreeNode node) {
        if (node == null) return true;
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }


    //    node                    x
    //    /  \       左旋转      /   \
    //   T1   x     ------->  node  T3
    //       / \              /  \
    //      T2 T3            T1  T2
    private TreeNode leftRotate(TreeNode node) {
        TreeNode x = node.right;

        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    //颜色翻转
    private void flipColors(TreeNode node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    //    node                    x
    //    /  \       右旋转      /   \
    //   x   T2     ------->   y   node
    //  / \                        /  \
    // y  T1                      T1  T2
    private TreeNode rightRotate(TreeNode node) {
        TreeNode x = node.left;

        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 插入操作
     **/
    public void add(E e) {
        root = add(root, e);
        root.color = BLACK;
    }

    private TreeNode leftRotate() {

    }

    ;


    // 将节点E插入 node 节点的子树中
    // 返回插入节点后的二叉查找树的节点
    private TreeNode add(TreeNode node, E e) {
        // 1 递归终止条件
        if (node == null) {
            size++;
            return new TreeNode(e);
        }
        //2.递归调用
        if (e.compareTo(node.data) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.data) > 0) {
            node.right = add(node.right, e);
        }

        // 更新父亲接口的高度
        // 父亲节点的高度值等于左右子节点最大高度值再加上1
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // 计算每个父亲节点的平衡因子
        int balanceFactor = getBalanceFactor(node);

        //左边不平衡 进行右旋转
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        //右边不平衡 进行左旋转
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            //左旋LL
            node.left = leftRotate(node.left);
            //右旋
            return rightRotate(node);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            //右旋 RR
            node.right = rightRotate(node.right);
            //左旋
            return leftRotate(node);
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
        List<E> res = new ArrayList<>();

        preOrder(root, res);

        return res;
    }

    private void preOrder(TreeNode node, List<E> res) {
        if (node == null) {
            return;
        }

        res.add(node.data);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    /**
     * 中序遍历
     */
    public List<E> inOrder() {
        List<E> res = new ArrayList<>();

        inOrder(root, res);

        return res;
    }

    private void inOrder(TreeNode node, List<E> res) {
        if (node == null) {
            return;
        }

        inOrder(node.left, res);
        res.add(node.data);
        inOrder(node.right, res);
    }

    /**
     * 后序遍历
     */
    public List<E> postOrder() {
        LinkedList res = new LinkedList<>();

        postOrder(root, res);

        return res;
    }

    private void postOrder(TreeNode node, List<E> res) {
        if (node == null) {
            return;
        }

        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.data);
    }

    /**
     * 最小值
     */
    public E minValue() {
        if (root == null) throw new RuntimeException("tree is null");
        return minValue(root).data;
    }

    public TreeNode minValue(TreeNode node) {
        if (node.left == null) return node;
        return minValue(node.left);
    }

    /**
     * 最大值
     */
    public E maxValue() {
        if (root == null) throw new RuntimeException("tree is null");
        return maxValue(root).data;
    }

    public TreeNode maxValue(TreeNode node) {
        if (node.right == null) return node;
        return maxValue(node.right);
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

    /**
     * 删除任意节点
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    // node为根节点的子树中删除e
    // 返回删除后的子树的根节点
    public TreeNode remove(TreeNode node, E e) {
        if (node == null) return null;
        TreeNode res = null;
        int compareValue = e.compareTo(node.data);
        if (compareValue < 0) {
            node.left = remove(node.left, e);
            res = node;
        } else if (compareValue > 0) {
            node.right = remove(node.right, e);
            res = node;
        } else {
            if (node.left == null) {
                TreeNode rightRoot = node.right;
                node.right = null;
                size--;
                res = rightRoot;
            }
            if (node.right == null) {
                TreeNode leftRoot = node.left;
                node.left = null;
                size--;
                res = leftRoot;
            }

            if (node.left != null && node.right != null) {
                // 后继节点
                TreeNode successor = minValue(node.right);

                node.left = successor.left;
                node.right = remove(node.right, successor.data);
                successor.right = null;
                successor.left = null;

                size--;
                res = successor;
            }
        }

        // 更新父亲接口的高度
        // 父亲节点的高度值等于左右子节点最大高度值再加上1
        if (res == null) return null;

        res.height = Math.max(getHeight(res.left), getHeight(res.right)) + 1;

        // 计算每个父亲节点的平衡因子
        int balanceFactor = getBalanceFactor(res);

        //左边不平衡 进行右旋转
        if (balanceFactor > 1 && getBalanceFactor(res.left) >= 0) {
            return rightRotate(res);
        }

        //右边不平衡 进行左旋转
        if (balanceFactor < -1 && getBalanceFactor(res.right) <= 0) {
            return leftRotate(node);
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(res.left) < 0) {
            //左旋LL
            res.left = leftRotate(res.left);
            //右旋
            return rightRotate(res);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(res.right) > 0) {
            //右旋 RR
            res.right = rightRotate(res.right);
            //左旋
            return leftRotate(res);
        }
        return res;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "AAAA%s";
        System.out.println(String.format(s, "123"));
    }

}
