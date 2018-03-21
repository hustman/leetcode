package com.zeus.array;

import org.junit.Assert;
import org.junit.Test;


/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 * @author xuxingbo
 * @Date 2018/3/21
 */
public class MaximumProductofThreeNumbers_628 {
    
    /**
     * 首先不管怎么说，n个数中，三个相乘的最大积，一定等于最大的一个数 * 余下数中两个数相乘的最大积
     * 考虑四种情况：
     * 1.全为正数，例如 1，3，5，7，9   最大积为 5 * 7 * 9
     * 2.全为负数，例如-1，-3，-5，-7，-9，最大积等于 -1 * （-3） * （-5），这里-1最大
     * 3.一个负数，其余全是正数
     * 4.一个正数，其余全是负数
     * 5.正负数都超过两个
     */
    public int maximumProduct(int[] nums) {
        int MAX_1 = Integer.MIN_VALUE;
        int MAX_2 = Integer.MIN_VALUE;
        int MAX_3 = Integer.MIN_VALUE;
        
        int MIN_1 = Integer.MAX_VALUE;
        int MIN_2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > MAX_1) {   //biggest
                MAX_3 = MAX_2;
                MAX_2 = MAX_1;
                MAX_1 = num;
            } else if (num > MAX_2) { //MAX_2 < num < MAX_1
                MAX_3 = MAX_2;
                MAX_2 = num;
            } else if (num > MAX_3) {
                MAX_3 = num;
            }
            if (num < MIN_1) {
                MIN_2 = MIN_1;
                MIN_1 = num;
            } else if (num < MIN_2) {
                MIN_2 = num;
            }
        }
        return Math.max(MAX_1 * MAX_2 * MAX_3, MAX_1 * MIN_1 * MIN_2);
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1};
        Assert.assertEquals(maximumProduct(nums), 1);
        
        nums = new int[]{-1,-2,-3};
        Assert.assertEquals(maximumProduct(nums), -6);
    }
}
