package com.course.highlevel.set;

import com.course.tree.blancesSeachTree.Bst;

import java.util.List;

/**
 * @author freed
 * @Description: 二叉查找树
 * @Date 2022-07-30
 */
public class BSTSet<E extends Comparable> implements Set<E> {
    private Bst<E> data;

    public BSTSet() {
        this.data = new Bst<>();
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void add(E e) {
        data.add(e);
    }

    @Override
    public void remove(E e) {
        data.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }

    public List<E> getAllElement() {
        return data.inOrder();
    }

    public static void main(String[] args) {
        BSTSet<Integer> bstSet = new BSTSet<>();
        bstSet.add(2);
        bstSet.add(1);
        bstSet.add(5);
        bstSet.add(9);
        bstSet.add(2);
        System.out.println(bstSet.getAllElement());
    }
}
