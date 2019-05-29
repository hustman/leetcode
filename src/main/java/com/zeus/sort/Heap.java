package com.zeus.sort;

import java.util.Arrays;

/**
 * @author xuxingbo
 * @Date 2019/5/29
 */
public class Heap {
    
    
    private static void maxHeapSort(int[] nums) {
        
        buildMaxHeap(nums);
        
        for (int i = nums.length - 1; i > 0; i--) {
            System.out.println(Arrays.toString(nums));
            swap(nums, 0, i);
            adjustMaxHeap(nums, 0, i);
        }
    }
    
    public static void buildMaxHeap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        //构建大顶堆，从第一个非叶子节点(length/2-1)开始调整
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(nums, i, nums.length);
        }
    }
    
    public static void adjustMaxHeap(int[] nums, int pos, int length) {
        if (nums == null || length <= 0) {
            return;
        }
        int temp = nums[pos];
        for (int k = 2 * pos + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                //右边的节点比较大，说明即使不满足要求，也是从右边的分支开始计算，因此k++，走到右边的分支
                k++;
            }
            if (nums[k] > temp) {
                //交换，然后找到最终位置坐标，不忙进行赋值
                nums[pos] = nums[k];
                pos = k;
            } else {
                //说明这个位置不用调整，直接break
                break;
            }
        }
        //找到最终位置，进行替换
        nums[pos] = temp;
    }
    
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 7, 6, 8, 2, 5, 4, 9, 1};
        maxHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
