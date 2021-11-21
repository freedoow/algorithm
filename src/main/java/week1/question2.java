package week1;

import entity.ListNode;


public class question2 {

    /**
     * 对于不为空的数据，对比得到最小的，赋值给新的链表
     * 取另一个链表next，再次进行对比 直到遇到null值
     **/
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode return_head = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }

        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }

        return return_head.next;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();

        listNode.val = 1;
        listNode.next = listNode2;

        listNode2.val = 2;
        listNode2.next = listNode3;

        listNode3.val = 3;
        System.out.println(listNode.toString());


        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();
        ListNode listNode6 = new ListNode();

        listNode4.val = 1;
        listNode4.next = listNode5;

        listNode5.val = 2;
        listNode5.next = listNode6;

        listNode6.val = 3;

        System.out.println(listNode4.toString());

    }
}
