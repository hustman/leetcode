package com.zeus.LinkedList;

/**
 * @author xuxingbo
 * @Date 2018/4/7
 */
public class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }
    
    /**
     * 方便创建链表
     *
     * @param nums
     * @return
     */
    static ListNode createList(int... nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(-1); //头结点
        ListNode prev = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            prev.next = node;
            prev = prev.next;
        }
        return head.next;
    }
    
    /**
     * 打印链表
     */
    static String printList(ListNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        ListNode temp = node;
        while (temp != null) {
            sb.append(temp.val).append(",");
            temp = temp.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ListNode) {
            ListNode obj1 = (ListNode) obj;
            boolean statu1 = this.val == obj1.val;
            boolean status2 = this.next == obj1.next || this.next.equals(obj1.next);
            return statu1 & status2;
        }
        return false;
    }
}
