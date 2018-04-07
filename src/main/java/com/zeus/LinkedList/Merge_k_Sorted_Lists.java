package com.zeus.LinkedList;


import java.util.Vector;

/**
 * @author xuxingbo
 * @Date 2018/4/7
 */
public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        Vector<ListNode> vector = new Vector<ListNode>();
        vector.copyInto(lists);
        while (vector.size() > 1) {
            ListNode first = vector.remove(0);
            ListNode second = vector.remove(0);
            vector.add(mergeTwoLists(first, second));
        }
        return vector.get(0);
    }
    
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
