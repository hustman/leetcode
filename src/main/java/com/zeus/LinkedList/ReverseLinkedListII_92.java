package com.zeus.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/4/12
 * 反转从位置 m 到 n 的链表。用一次遍历在原地完成反转。

    例如：
    给定 1->2->3->4->5->NULL, m = 2 和 n = 4,
    
    返回 1->4->3->2->5->NULL.
    
    注意:
    给定 m，n 满足以下条件：
    
    1 ≤ m ≤ n ≤ 列表长度。
 */
public class ReverseLinkedListII_92 {
    
    /**
     * 使用头插入法，顺序插入，得到的就是逆序
     * 例如使用头插入法插入1->2->3，得到的链表为3->2->1
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode prev = root;
        for(int i = 0; i < m-1; i++) prev = prev.next;
        
        ListNode start = prev.next;
        ListNode then = start.next;
        
        for(int i = 0; i < n-m; i++){
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        return root.next;
    }
    
    
    @Test
    public void test(){
        ListNode head = ListNode.createList(1,2,3,4,5);
        Assert.assertEquals(reverseBetween(head,2,4),
                ListNode.createList(1,4,3,2,5));
    }
}
