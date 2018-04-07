package com.zeus.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/4/7
 */
public class Remove_nth_node_from_tail {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (i++ < n) {
            fast = fast.next;
        }
        //如果链表的长度刚好为n，需要进行一下判断，否则空指针异常
        if (fast == null) {
            return slow.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode remove = slow.next;
        slow.next = remove.next;
        return head;
    }
    
    @Test
    public void test() {
        ListNode head = ListNode.createList(1, 2, 3, 4, 5);
        ListNode actual = removeNthFromEnd(head, 2);
        ListNode expected = ListNode.createList(1, 2, 3, 5);
        Assert.assertEquals(expected, actual);
        
        Assert.assertEquals(ListNode.createList(2, 3),
                removeNthFromEnd(ListNode.createList(1, 2, 3), 3));
    }
}
