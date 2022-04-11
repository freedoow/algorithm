package com.course.line.algo.linkedlist.tain;

import com.course.line.algo.linkedlist.ListNode;

/**
 * @author whb
 * @Description: 链表的中间节点 如果是偶数返回后面的那一个
 * @Date 2022-03-07
 */
public class _876_MiddleOfTheLinkedList {
    public static ListNode middle(ListNode head) {
        if (head == null && head.next == null) return head;
        //计算节点数
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        //找到中间值
        for (int i = 0; i < count / 2; i++) {
            head = head.next;
        }
        return head;
    }

    //快慢指针
    public static ListNode middle1(ListNode head) {
        if (head == null && head.next == null) return head;

        //声明两个指针
        ListNode slow = head;
        ListNode fast = head;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] data = new int[]{23, 12, 11, 34, 11};
        ListNode listNode = ListNode.fromArray(data);
        System.out.println(_876_MiddleOfTheLinkedList.middle1(listNode).toString());
    }
}
