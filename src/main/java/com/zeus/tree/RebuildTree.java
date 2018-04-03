package com.zeus.tree;

/**
 * @author xuxingbo
 * @Date 2018/3/22
 */
public class RebuildTree {
    private class Node{
        public Node left;
        public Node right;
        public int value;
    
        public Node(int value) {
            this.value = value;
        }
    
        public Node(int value,Node left, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    
/*    public Node rebuild(int[] first, int[] second){
        
    }
    
    public Node rebuild(int[] first,int low, int high, int[] second, int low1,int hight1){
        Node root = new Node(first[low]);
        int rootIndex2 = findRootIndex(second, low1, hight1, first[low]);
        int rootIndex1 = findRootIndex(first,low,high,second[rootIndex2]);
        Node left = rebuild(first,low, rootIndex1-1,)
    }*/
    
    private int findRootIndex(int[] nums, int start, int end, int root){
        while(start < end){
            if(nums[start] == root){
                return start;
            }
            start++;
        }
        return -1;
    }
    
/*    public void test(){
        int[] first= new int[]{10,6,4,8,14,12,16};
        int[] middle = new int[]{4,6,8,10,12,14,16};
        Node node = rebuild(first, middle);
    }*/
}
