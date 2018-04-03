package com.zeus.LinkedList;

import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/4/3
 * 合并两个已排序的链表，并将其作为一个新列表返回。新列表应该通过拼接前两个列表的节点来完成。
 * 例如：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Merge_Two_Sorted_Lists_021 {
    private static class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }
    
    /**
     * 解法1，使用遍历法
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ) return l2;
        if(l2 == null) return l1;
        ListNode first = l1, second = l2;
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while(first != null && second != null){
            if(first.val <= second.val ){
                prev.next = first;
                first = first.next;
            }else{
                prev.next = second;
                second = second.next;
            }
            prev = prev.next;
        }
        if(first != null){
            prev.next = first;
        }
        if(second != null){
            prev.next = second;
        }
        return head.next;
    }
    
    /**
     * 解法2：使用递归的方法
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null ) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists1(l1,l2.next);
            return l2;
        }
    }
    
    @Test
    public void test(){
        ListNode l1 = createList(new int[]{1,2,4});
        ListNode l2 = createList(new int[]{1,3,4});
        ListNode result = mergeTwoLists(l1,l2);
        System.out.println(printList(result));
    }
    
    @Test
    public void test1(){
        ListNode l1 = createList(new int[]{1,2,4});
        ListNode l2 = createList(new int[]{1,3,4});
    
        ListNode result2 = mergeTwoLists1(l1,l2);
        System.out.println(printList(result2));
    }
    
    /**
     * 方便创建链表
     * @param nums
     * @return
     */
    private ListNode createList(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        ListNode head = new ListNode(-1); //头结点
        ListNode prev = head;
        for(int num : nums){
            ListNode node = new ListNode(num);
            prev.next = node;
            prev = prev.next;
        }
        return head.next;
    }
    
    /**
     * 打印链表
     */
    private String printList(ListNode node){
        if(node == null){
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        ListNode temp = node;
        while(temp != null){
            sb.append(temp.val).append(",");
            temp = temp.next;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
}
