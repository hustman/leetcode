package com.zeus.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/4/19
 * 请检查一个链表是否为回文链表。
 * 你能在 O(n) 的时间和 O(1) 的额外空间中做到吗？
 */
public class PalindromeLinkedList_234 {
    /**
     * 定义一个快慢指针，慢的一次走一步，快的一次走两步
     * 当快的到达尾部的时候，慢的刚好在中间位置
     * 对于前半部分遍历的节点，使用头插法构造新链表
     * 相当与将前半部分倒序了一下，然后和后半部分顺序比较即可
     * 注意当链表中节点个数为奇数的时候，要跳过中间节点
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode firstHalf = null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            ListNode tmp = firstHalf;
            firstHalf = slow;
            slow = slow.next;
            fast = fast.next.next;
            firstHalf.next = tmp;
        }
        if (fast != null) {
            slow = slow.next; //跳过中间节点
        }
        while (firstHalf != null && slow != null) {
            if (slow.val != firstHalf.val) {
                return false;
            }
            slow = slow.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }
    
    @Test
    public void testCase1() {
        ListNode head = ListNode.createList(1, 2, 2, 1);
        
        Assert.assertTrue(isPalindrome(head));
        
    }
    
    @Test
    public void testCase2() {
        ListNode head = ListNode.createList(1, 2, 1);
        Assert.assertTrue(isPalindrome(head));
    }
}
