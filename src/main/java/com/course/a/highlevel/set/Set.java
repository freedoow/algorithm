package com.course.a.highlevel.set;

/**
 * @author freed
 * @Description:
 * @Date 2022-07-30
 */
public interface Set<E> {
    int size();

    boolean isEmpty();

    void add(E e);

    void remove(E e);

    boolean contains(E e);

}
