package com.course.a.tree.avl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author whb
 * @Description: AVL
 * @Date 2022-07-09
 */
public class AVLTree<E extends Comparable> {
    private class TreeNode {
        E data;
        TreeNode left;
        TreeNode right;
        int height = 1;

        public TreeNode(E data) {
            this.data = data;
        }
    }

    private TreeNode root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
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

    // 左旋转
    // 对节点 y 进行向右旋转操作，返回旋转后新的根节点 x
    //        y                                    x
    //       / \                                 /   \
    //      x   T4        向右旋转 (y)          z       y
    //     / \          --------------->      / \     / \
    //    z   T3                            T1   T2 T3   T4
    //   / \
    // T1   T2
    public TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode t3 = x.right;

        // 右旋转
        x.right = y;
        y.left = t3;
        // 计算子节点 才能父节点
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T4   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T3  z                     T4 T3 T1 T2
    //      / \
    //     T1 T2
    public TreeNode leftRotate(TreeNode y) {
        TreeNode x = y.right;
        TreeNode t3 = x.left;

        // 左旋转
        x.left = y;
        y.right = t3;

        // 计算子节点 才能父节点
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
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
