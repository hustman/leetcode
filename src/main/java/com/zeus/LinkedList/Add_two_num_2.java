package com.zeus.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/4/7
 */
public class Add_two_num_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        ListNode first = l1, second = l2;
        int flag = 0;
        while (first != null && second != null) {
            int num = (first.val + second.val + flag) % 10;
            flag = (first.val + second.val + flag) / 10;
            prev.next = new ListNode(num);
            prev = prev.next;
            first = first.next;
            second = second.next;
        }
        if (first == null) {
            while (second != null) {
                int num = (second.val + flag) % 10;
                flag = (second.val + flag) / 10;
                prev.next = new ListNode(num);
                prev = prev.next;
                second = second.next;
            }
        } else {
            while (first != null) {
                int num = (first.val + flag) % 10;
                flag = (first.val + flag) / 10;
                prev.next = new ListNode(num);
                prev = prev.next;
                first = first.next;
            }
        }
        if (flag != 0) {
            prev.next = new ListNode(flag);
        }
        return head.next;
    }
    
    /**
     * 上面的代码太过于繁琐，有很多地方可以进行简化
     * 下面是简化后的代码
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1); // 头结点
        ListNode prev = head, first = l1, second = l2;
        int flag = 0; //前面相加是否产生了进位
        while (first != null || second != null) {
            int sum = flag;
            if (first != null) {
                sum += first.val;
                first = first.next;
            }
            if (second != null) {
                sum += second.val;
                second = second.next;
            }
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            flag = sum / 10;
        }
        if (flag != 0) {
            prev.next = new ListNode(flag);
        }
        return head.next;
    }
    
    class TestSute {
        ListNode first;
        ListNode second;
        ListNode result;
        
        public TestSute(ListNode first, ListNode second, ListNode result) {
            this.first = first;
            this.second = second;
            this.result = result;
        }
    }
    
    TestSute[] testSutes;
    
    @Before
    public void setUp() {
        testSutes = new TestSute[2];
        testSutes[0] = new TestSute(
                ListNode.createList(7, 0, 5),
                ListNode.createList(3, 9, 4),
                ListNode.createList(0, 0, 0, 1));
        testSutes[1] = new TestSute(
                ListNode.createList(5),
                ListNode.createList(5),
                ListNode.createList(0, 1));
    }
    
    @Test
    public void testMethod1() {
        for (TestSute sute : testSutes) {
            Assert.assertEquals(sute.result, addTwoNumbers(sute.first, sute.second));
        }
    }
    
    @Test
    public void testMethod2() {
        for (TestSute sute : testSutes) {
            Assert.assertEquals(sute.result, addTwoNumbers1(sute.first, sute.second));
        }
    }
}
