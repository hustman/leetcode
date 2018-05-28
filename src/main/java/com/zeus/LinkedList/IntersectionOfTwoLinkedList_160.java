package com.zeus.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/5/28
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class IntersectionOfTwoLinkedList_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = getListLength(headA);
        int length2 = getListLength(headB);
        
        //始终让第一个链表的长度大于第二个链表，这样可以节省后面的判断运算
        if (length1 < length2){
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }
        //长链表先走
        int k = Math.abs(length1 - length2);
        while(k > 0){
            headA = headA.next;
            k--;
        }
        //同步向前，相遇则返回节点，否则返回null
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
        
    }
    
    private int getListLength(ListNode head){
        ListNode tmp = head;
        int count = 0;
        while(tmp != null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }
    
    
    @Test
    public void test(){
        ListNode list1 = ListNode.createList(1,2);
        ListNode list2 = ListNode.createList(1,2,3,4);
        ListNode common = ListNode.createList(7,8,9,5);
        
        ListNode temp1 = list1;
        while(temp1.next != null){
            temp1 = temp1.next;
        }
        temp1.next = common;
        
        ListNode temp2 = list2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = common;
        
        ListNode node = getIntersectionNode(list1, list2);
        Assert.assertNotNull(node);
        System.out.println(ListNode.printList(node));
        
        
    }
}
