package com.course.line.algo.linkedlist.tain;

import com.course.line.algo.linkedlist.ListNode;

/**
 * @author whb
 * @Description:
 * @Date 2022-04-18
 */
public class _147_InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prve = head;
        ListNode curr = head.next;

        while (curr.next != null) {
            if (curr.value >= prve.value) {
                prve = curr;
                curr = curr.next;

            } else {
                ListNode p = dummyNode;
                while (p.next != null && p.next.value < curr.value) {
                    p = p.next;
                }
                prve.next = curr.next;
                curr.next = p.next;
                p.next = curr;

                curr = prve.next;
            }
        }
        return dummyNode.next;

    }

}
