package com.course.a.line.stack;

/**
 * @Description: 栈抽象
 * @author freedoow
 * @Date 2021-12-12
 */
public interface Stack<E> {
    /**
     * 查看栈元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 进栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();
}
