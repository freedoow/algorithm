package com.course.a.highlevel.heap;

/**
 * @author whb
 * @Description:
 * @Date 2022-07-14
 */
public class DataStream1 {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node dummyNode;

    public DataStream1() {
        this.dummyNode = new Node(-1);
    }

    public void add(int val) {
       //找到第一个比val小的节点
        Node prev = dummyNode;
        Node curr = dummyNode.next;
        while (curr != null){
            if (curr.val <val){
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        //添加到第一个比它小的节点前面
        Node newNode = new Node(val);
        newNode.next = curr;
        prev.next = newNode;
    }

    public int removeMax() {
        if (dummyNode.next == null) throw new RuntimeException("removeMax 失败， 因为数据流中没有元素");
        int res = dummyNode.next.val;
        //删除头节点
        Node head = dummyNode.next;
        dummyNode.next  = head.next;
        head.next = null;
        return res;
    }
}

