package com.zeus.LinkedList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xuxingbo
 * @Date 2018/4/7
 */
public class Merge_k_Sorted_Lists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        List<ListNode> vector = new ArrayList<ListNode>(lists.length);
        Collections.addAll(vector, lists);
        while (vector.size() > 1) {
            ListNode first = vector.remove(0);
            ListNode second = vector.remove(0);
            vector.add(mergeTwoLists(first, second));
        }
        return vector.get(0);
    }
    
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    
    public static void main(String[] args){
        ListNode list1 = ListNode.createList(1,4,5);
        ListNode list2 = ListNode.createList(1,3,4);
        ListNode list3 = ListNode.createList(2,6);
        ListNode[] listNodes = new ListNode[]{list1,list2, list3};
        ListNode result = mergeKLists(listNodes);
        System.out.println(ListNode.printList(result));
    }
}
