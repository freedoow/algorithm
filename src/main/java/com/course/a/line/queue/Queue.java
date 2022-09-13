package com.course.a.line.queue;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-14
 */
public interface Queue<E> {
    /**
     * 查询队列中的个数
     *
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return
     */
    E dequeue();

    /**
     * 查看队首的元素
     *
     * @return
     */
    E getFront();
}
