package com.course.a.line.algo.linkedlist.tain;

import com.course.a.line.algo.linkedlist.ListNode;

/**
 * @author freedoow
 * @Description: 删除目标元素的所有节点
 * @Date 2022-03-07
 */
public class _203_deleteTargetValue {

    public static ListNode delete(ListNode head, int val) {
        // 1、表头
        while (head != null && head.value == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) return null;


        //2、非表头
        ListNode prevNode = head;
        ListNode currNode = head.next;
        while (head != null) {
            if (currNode.value == val) {
                prevNode.next = currNode.next;
                currNode.next = null;
                //currNode = prevNode.next;
            } else {
                prevNode = currNode;
                //currNode = currNode.next;
            }
            currNode = prevNode.next;

        }
        return head;
    }


    // 优化
    public static ListNode delete1(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prevNode = dummyNode;
        ListNode currNode = head;

        while (currNode != null) {
            if (currNode.value == val) {
                prevNode.next = currNode.next;
                currNode.next = null;
                //currNode = prevNode.next;
            } else {
                prevNode = currNode;
                //currNode = currNode.next;
            }
            currNode = prevNode.next;

        }

        return dummyNode.next;
    }

}
