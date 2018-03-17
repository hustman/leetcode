package com.zeus.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/18
 */
public class MaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0, temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                temp++;
                if(temp > result) result = temp;
            }else{
                temp = 0;
            }
        }
        return result;
    }
    
    @Test
    public void test(){
        int[] nums = {1, 1, 0, 1, 1, 1};
        Assert.assertEquals(findMaxConsecutiveOnes(nums), 3);
    }
}
