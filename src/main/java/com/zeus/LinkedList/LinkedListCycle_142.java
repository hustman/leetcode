package com.zeus.LinkedList;

/**
 * @author xuxingbo
 * @Date 2018/4/10
 * 给一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 说明：不应修改给定的链表。
 */
public class LinkedListCycle_142 {
    /**
     * 定义一个快慢指针，当两个指针相遇的时候，将其中一个指针重置
     * 然后两个指针按照正常的步骤向前走，当第一次相遇的时候的节点
     * 就是开始入环的第一个节点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
