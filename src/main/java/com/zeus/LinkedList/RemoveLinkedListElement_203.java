package com.zeus.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/4/19
 * 删除链表中等于给定值 val 的所有元素
 */
public class RemoveLinkedListElement_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) return removeElements(head.next, val);
        ListNode prev = head;
        ListNode next = prev.next;
        while(next != null){
            if(next.val == val){
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
        ListNode testCase1 = ListNode.createList(1,2);
        Assert.assertEquals(ListNode.createList(2), removeElements(testCase1, 1));
        
        ListNode testCase2 = ListNode.createList(1,2,3);
        Assert.assertEquals(ListNode.createList(1,3),removeElements(testCase2,2));
        
        ListNode testCase3 = ListNode.createList(1);
        Assert.assertEquals(null, removeElements(testCase3,1));
    }
}
