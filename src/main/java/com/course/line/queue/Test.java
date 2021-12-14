package com.course.line.queue;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-14
 */
public class Test {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue.toString());
        arrayQueue.dequeue();
        System.out.println(arrayQueue.toString());
        arrayQueue.dequeue();
        System.out.println(arrayQueue.toString());

        System.out.println("--------------");

        LinkedListQueue<Object> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enqueue(1);
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(3);
        System.out.println(linkedListQueue.toString());
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue.toString());
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue.toString());

    }
}
