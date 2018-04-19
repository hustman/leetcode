package com.zeus.LinkedList;

/**
 * @author xuxingbo
 * @Date 2018/4/19
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。
 * 比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点
 * 那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。
 */
public class RemoveNodeFromSortedList_237 {
    
    /**
     * 参数为被删除的节点
     * @param node 被删除的节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
