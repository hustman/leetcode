package com.zeus;

/**
 * @author xuxingbo
 * @Date 2018/3/12
 * 153
 */
public class MinimumRotate {
    
    public static int findMin(int[] nums){
        int low = 0, high = nums.length-1;
        while( low < high){
            if(nums[low] < nums[high]){
                return nums[low];
            }
            
            int mid = (low + high) / 2;
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
    
    public static void main(String[] args){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
