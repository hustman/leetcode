package com.zeus.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/17
 */
public class TwoSumII_167 {
    
    public int[] twoSum1(int[] numbers, int target) {
        for(int i = 0; i < numbers.length-1;i++){
            int j = binarySearch(numbers,i,target-numbers[i]);
            if(j > 0){
                return new int[]{i+1,j+1};
            }
        }
        return null;
    }
    
    public int[] twoSum2(int[] numbers, int target){
        int[] result = new int[2];
        if(numbers == null || numbers.length == 1){
            return result;
        }
        int left = 0, right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        return result;
    }
    
    private int binarySearch(int[] numbers, int start, int target){
        int low = start+1, high = numbers.length-1;
        while(low <= high){
            int middle = (low + high) >>> 1;
            if(numbers[middle] == target){
                return middle;
            }else if(numbers[middle] > target){
                high = middle-1;
            }else{
                low = middle + 1;
            }
        }
        return -1;
    }
    
    @Test
    public void test(){
        int[] numbers = new int[]{1,3,4,4,6,9};
        int target = 8;
        
        int[] result = new int[]{3,4};
        Assert.assertArrayEquals(twoSum1(numbers, target), result);
        Assert.assertArrayEquals(twoSum2(numbers, target), result);
        
    }
}
