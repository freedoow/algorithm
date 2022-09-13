package com.course.a.line.algo.linkedlist;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-03-06
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode curr = this;

        while (curr != null) {
            sb.append(curr.value).append("->");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }


    /**
     * 数组转节点
     *
     * @param data
     * @return
     */
    public static ListNode fromArray(int[] data) {
        if (data == null && data.length == 0) return null;

        ListNode head = new ListNode(data[0]);
        ListNode curr = head;
        for (int i = 1; i < data.length; i++) {
            curr.next = new ListNode(data[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * @param listNode
     * @return
     */
    public static int count(ListNode listNode) {
        if (listNode == null) return -1;
        ListNode curr = listNode;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    /**
     * 目标个数
     *
     * @param listNode
     * @return
     */
    public static int countTarget(ListNode listNode, int target) {
        if (listNode == null) return -1;
        ListNode curr = listNode;
        int count = 0;
        while (curr != null) {
            if (target == curr.value) count++;
            curr = curr.next;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] data = new int[]{23, 12, 11, 34, 11};
        ListNode listNode = ListNode.fromArray(data);
        System.out.println(listNode.toString());
        System.out.println(ListNode.countTarget(listNode, 11));
    }
}
