package com.course.a.highlevel.heap;

/**
 * @author whb
 * @Description:
 * @Date 2022-07-14
 */
public class DataStream {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node dummyNode;

    public DataStream() {
        this.dummyNode = new Node(-1);
    }

    public void add(int val) {
        Node newNode = new Node(val);
        newNode.next = dummyNode.next;
        dummyNode.next = newNode;
    }

    public int removeMax() {
        if (dummyNode.next == null) throw new RuntimeException("removeMax 失败， 因为数据流中没有元素");

        //最大值节点
        Node curr = dummyNode.next;
        Node maxValueNode = dummyNode.next;
        while (maxValueNode.next != null) {
            if (curr.val > maxValueNode.val) {
                maxValueNode = curr;
            }
            curr = curr.next;
        }

        // 找到最大值节点的前一个节点
        curr = dummyNode.next;  // 1
        Node maxValueNodePrev = dummyNode; //  -1
        while (curr != null) {
            //-1 1 2 3 4
            // 3
            if (curr == maxValueNode) {
                break;
            }
            maxValueNodePrev = curr;
            curr = curr.next;
        }

        //删除最大值所在节点
        maxValueNodePrev.next = maxValueNode.next;
        maxValueNode.next = null;
        return maxValueNode.val;
    }
}

