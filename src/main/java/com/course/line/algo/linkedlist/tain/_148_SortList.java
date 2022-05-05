package com.course.line.algo.linkedlist.tain;

import com.course.line.algo.linkedlist.ListNode;

import java.util.logging.Handler;

/**
 * @author whb
 * @Description:
 * @Date 2022-04-25
 */
public class _148_SortList {


    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        for (int step = 0; step < length; step += step) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, step);
                //分割得到下次处理的链表头
                curr = split(right, step);
                prev = marge(left, right, prev);
            }
        }
        return dummy.next;
    }

    private ListNode marge(ListNode left, ListNode right, ListNode prev) {
        ListNode curr = prev;

        while (left != null && right != null) {
            if (left.value <= right.value) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left == null) curr.next = right;
        if (right == null) curr.next = left;
        if (curr.next != null) curr = curr.next;

        return curr;

    }


    private ListNode split(ListNode node, int step) {
        if (node == null) return null;
        //找到分割点
        for (int i = 1; node.next != null && i < step; i++) {
            node = node.next;
        }
        ListNode right = node.next;
        node.next = null;
        return right;
    }


    public static ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        //找中间节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode leftNode = sortList1(head);
        ListNode rightNode = sortList1(rightHead);

        // 合并
        return _21_MergeTwoSortedLists.merge(leftNode, rightNode);
    }
}
