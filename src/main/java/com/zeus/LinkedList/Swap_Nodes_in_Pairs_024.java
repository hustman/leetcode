package com.zeus.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/4/10
 * <p>
 * 给定一个链表，对每两个相邻的结点作交换并返回头节点。
 * 例如：
 * 给定 1->2->3->4，你应该返回 2->1->4->3。
 * 你的算法应该只使用额外的常数空间。不要修改列表中的值，只有节点本身可以​​更改。
 */
public class Swap_Nodes_in_Pairs_024 {
    
    /**
     * 非递归的解法，循环
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = head.next;
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode tmp = current;
            current = current.next;
            tmp.next = current.next;
            current.next = tmp;
            current = tmp.next;
            if (current != null && current.next != null)
                tmp.next = current.next;
        }
        return root;
    }
    
    /**
     * 递归的解法
     */
    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = head.next;
        head.next = swapPairsRecursion(root.next);
        root.next = head;
        return root;
    }
    
    @Test
    public void test() {
        
        ListNode testCase1 = ListNode.createList();
        Assert.assertEquals(null, swapPairs(testCase1));
        
        ListNode testCase2 = ListNode.createList(1);
        Assert.assertEquals(ListNode.createList(1), swapPairs(testCase2));
        
        ListNode testCase3 = ListNode.createList(1, 2, 3);
        Assert.assertEquals(ListNode.createList(2, 1, 3), swapPairs(testCase3));
        
        ListNode testCase4 = ListNode.createList(1, 2, 3, 4);
        Assert.assertEquals(ListNode.createList(2, 1, 4, 3), swapPairs(testCase4));
        
        ListNode testCase5 = ListNode.createList(1, 2, 3, 4, 5);
        Assert.assertEquals(ListNode.createList(2, 1, 4, 3, 5), swapPairs(testCase5));
        
    }
}
