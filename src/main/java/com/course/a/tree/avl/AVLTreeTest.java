package com.course.a.tree.avl;

/**
 * @author whb
 * @Description:
 * @Date 2022-07-09
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.add(10);
        avlTree.add(11);
        avlTree.add(12);
        System.out.println(avlTree.isBST());
        System.out.println(avlTree.isBalanced());
    }
}
