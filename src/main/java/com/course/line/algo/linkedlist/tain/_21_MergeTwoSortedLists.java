package com.course.line.algo.linkedlist.tain;

import com.course.line.algo.linkedlist.ListNode;

/**
 * @author freedoow
 * @Description: 合并两个有序列表
 * @Date 2022-03-07
 */
public class _21_MergeTwoSortedLists {

    // 迭代
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;

        }
        if (l1 == null) curr.next = l2;
        if (l2 == null) curr.next = l1;

        return dummyNode.next;
    }

    // 递归
    public static ListNode merge1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.value <= l2.value) {
            l1.next = merge1(l1.next, l2);
            return l1;
        }else {
            l2.next = merge1(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{8, 9, 10, 11, 12};
        ListNode l1 = ListNode.fromArray(data);
        int[] data2 = new int[]{6, 7, 7, 8, 9};
        ListNode l2 = ListNode.fromArray(data2);

        System.out.println(_21_MergeTwoSortedLists.merge1(l1, l2).toString());
    }
}
