package com.course.line.algo.linkedlist.tain;

import com.course.line.algo.linkedlist.ListNode;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-03-07
 */
public class _206_reverseListNode {

    public static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        return prev;
    }


    // 递归
    public static ListNode reverse1(ListNode head) {
        // 终结条件
        if (head == null || head.next == null) return head;

        ListNode p = reverse1(head);
        //归并
        head.next.next = head;
        head.next = null;
        return p;
    }

}
