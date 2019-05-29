package com.zeus.sort;

/**
 * @author xuxingbo
 * @Date 2019/5/30
 */
public class FindMinK {
    
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 1414, 44234, 1412, 212, 14214, 3523, 523, 4, 23423423, 42};
        
        for (int i = 1; i < nums.length; i++) {
            int find = findMink(nums, i);
            System.out.println(String.format("第%d小的数为:%d", i, find));
        }
        
    }
    
    private static int findMink(int[] nums, int k) {
        int[] maxHeap = new int[k];
        System.arraycopy(nums, 0, maxHeap, 0, k);
        Heap.buildMaxHeap(maxHeap);
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap[0]) {
                maxHeap[0] = nums[i];
                Heap.adjustMaxHeap(maxHeap, 0, k);
            }
        }
        
        return maxHeap[0];
    }
}
