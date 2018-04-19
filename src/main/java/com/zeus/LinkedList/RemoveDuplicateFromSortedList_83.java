package com.zeus.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/4/19
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
 */
public class RemoveDuplicateFromSortedList_83 {
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode next = prev.next;
        while(next != null){
            if(prev.val == next.val){
                prev.next = next.next;
            }else{
                prev = next;
            }
            next = next.next;
        }
        return head;
    }
    
    @Test
    public void test(){
        ListNode testCase1 = ListNode.createList(1,1,2);
        Assert.assertEquals(ListNode.createList(1,2), deleteDuplicates(testCase1));
        
        ListNode testCase2 = ListNode.createList(1,1,2,3,3);
        Assert.assertEquals(ListNode.createList(1,2,3), deleteDuplicates(testCase2));
        
        ListNode testCase3 = ListNode.createList(1,2);
        Assert.assertEquals(ListNode.createList(1,2),deleteDuplicates(testCase3));
        
        ListNode testCase4 = ListNode.createList(1,1);
        Assert.assertEquals(ListNode.createList(1), deleteDuplicates(testCase4));
    }
    
}
