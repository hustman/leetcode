package com.zeus.LinkedList;


/**
 * @author xuxingbo
 * @Date 2018/5/27
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class ConvertSortLinkListToBinarySearchTree_109 {
    
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }
    
    /**
     * 在链表中，通过定义两个快慢指针，可以迅速的将链表划分为两个部分
     * 然后对两个部分进行递归处理即可
     */
    public TreeNode sortedListToBST(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode treeHead = new TreeNode(slow.val);
        treeHead.left = sortedListToBST(head, slow);
        treeHead.right = sortedListToBST(slow.next, tail);
        return treeHead;
    }
    
    
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
