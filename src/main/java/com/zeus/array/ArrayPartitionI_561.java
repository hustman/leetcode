package com.zeus.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author xuxingbo
 * @Date 2018/3/15
 */
public class ArrayPartitionI_561 {
    
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
    
        for (int i = 0; i < nums.length; i+=2) {
            result += nums[i];
        }
        return result;
    }
    
    public int arrayPairSum2(int[] nums){
        quickSort(nums, 0, nums.length-1);
        int result = 0;
        for(int i = 0; i < nums.length; i += 2){
            result += nums[i];
        }
        return result;
    }
    
    private void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int middle = paration(nums, start, end);
        quickSort(nums,start, middle-1);
        quickSort(nums, middle+1, end);
    }
    
    private int paration(int[] nums, int start, int end){
        int key = nums[start];
        while(start < end){
            while( nums[end] >= key && start < end){
                end--;
            }
            nums[start] = nums[end];
            
            while( nums[start] <= key && start < end){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = key;
        return start;
    }
    
    @Test
    public void testArrayPartition(){
        int[] nums = new int[]{1,4,2,3};
        Assert.assertEquals(arrayPairSum(nums), arrayPairSum2(nums));
        
        nums = new int[]{1,5,4,3,2,6};
        Assert.assertEquals(arrayPairSum(nums), arrayPairSum2(nums));
    }
}
