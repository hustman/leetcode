package com.zeus.LinkedList;

import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/5/28
 *
 * 对链表进行插入排序。
 */
public class InsertionSortedList_147 {
    public ListNode insertionSortList(ListNode head) {
        //排序链表的头结点，统一添加头结点是为了避免恶心的判空操作
        ListNode sortedDummy = new ListNode(-1);
        ListNode unsorted = head;
        while(unsorted != null){
            ListNode prev = sortedDummy;
            ListNode pos = sortedDummy.next;
            //找到当前node在排序链表中的插入位置，以及插入位置的前一个节点引用
            while(pos != null && pos.val < unsorted.val){
                prev = pos;
                pos = pos.next;
            }
            //找到当前节点的插入位置后，进行的操作
            //1. 把当前未排序的节点指针向后移动
            //2. 把当前节点插入到排序链表中
            ListNode tmp = unsorted;
            unsorted = unsorted.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        return sortedDummy.next;
    }
    
    @Test
    public void test(){
        ListNode case1 = ListNode.createList(6,5,3,1,8,7,2,4);
        ListNode insertionSorted = insertionSortList(case1);
        System.out.println(ListNode.printList(insertionSorted));
        
        ListNode case2 = ListNode.createList(1,5,4,2,3);
        System.out.println(ListNode.printList(insertionSortList(case2)));
    }
}
