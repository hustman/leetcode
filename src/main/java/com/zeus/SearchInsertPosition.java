package com.zeus;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xuxingbo
 * @Date 2018/3/14
 */
public class SearchInsertPosition {
    /**
     * binary search
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high) >>> 1;
            if(target > nums[mid]){
                low = mid+1;
            }else if ( target < nums[mid]){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return low;
    }
    
    public int searchInsert2(int[] nums, int target){
        List<Integer> lists = new ArrayList<Integer>(nums.length);
        for (int num : nums) {
            lists.add(num);
        }
        int result = Collections.binarySearch(lists, target);
        return result >=0 ? result : -(1 + result);
    }
    
    
    @Test
    public void test(){
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    
        System.out.println(searchInsert2(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert2(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert2(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert2(new int[]{1,3,5,6}, 0));
        
    }
}
