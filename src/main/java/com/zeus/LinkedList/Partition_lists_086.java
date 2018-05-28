package com.zeus.LinkedList;

/**
 * @author xuxingbo
 * @Date 2018/5/27
 * 题目：
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 例如：
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Partition_lists_086 {
    /**
     * 思路：创建两个链表，一个为小于给定值x的链表small，另一个为大于等于给定值x的链表bigger
     * 依次循环遍历链表，如果最后small链表为空，那么直接返回bigger链表（去除头结点）
     * 如果small链表不为空，就把bigger链表串在small链表后面，然后返回small链表（去除头结点）
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead, sPrev, bigHead, bPrev;
        smallHead = sPrev = new ListNode(-1);
        bigHead = bPrev = new ListNode(-1);
        
        while(head != null){
            if(head.val < x){
                sPrev.next = head;
                sPrev = head;
            }else{
                bPrev.next = head;
                bPrev = head;
            }
            head = head.next;
        }
        bPrev.next = null;
        
        if(smallHead.next != null){
            sPrev.next = bigHead.next;
            return smallHead.next;
        }else{
            return bigHead.next;
        }
    }
}
