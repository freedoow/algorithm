package com.course.line.algo.linkedlist.tain;

import com.course.line.algo.linkedlist.ListNode;

/**
 * @author freedoow
 * @Description: 合并K个有序链表
 * @Date 2022-03-08
 */
public class _23_MergeKLinkedLists {


    // 分治思想
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left > right) return null;
        int mid = left + (right - left) / 2;

        ListNode mergedLeftList = merge(lists, left, mid);
        ListNode mergedRightList = merge(lists, mid + 1, left);

        return _21_MergeTwoSortedLists.merge(mergedLeftList, mergedRightList);

    }

    ;

    //顺序合并
    public static ListNode merge(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode outPut = lists[0];
        for (int i = 1; i < lists.length; i++) {
            outPut = _21_MergeTwoSortedLists.merge(outPut, lists[i]);
        }
        return outPut;
    }
}
