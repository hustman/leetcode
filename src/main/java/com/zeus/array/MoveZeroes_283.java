package com.zeus.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/17
 */
public class MoveZeroes_283 {
    /**
     * O(N)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index++] = nums[i]; //move non-zero number left
            }
        }
        while(index < nums.length){
            nums[index++] = 0; //append the last array with zero
        }
    }
    
    @Test
    public void test(){
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        Assert.assertArrayEquals(nums, new int[]{1, 3, 12, 0, 0});
        
    }
}
