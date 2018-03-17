package com.zeus.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxingbo
 * @Date 2018/3/17
 * 448. Find All Numbers Disappeared in an Array
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Input:  [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */
public class FindAllNumbers_448 {
    /**
     * 使用原数组来标记数字是否出现，由于原来的数字都是1..n之间的正整数，因此
     * 可以使用对应位置取反的方法进行标记,假设nums=[4,3,2,7,8,2,3,1]
     * 当i=0时，nums[i]=4,所以nums[nums[i]-1]=nums[3]=-nums[3]=-7
     * <p>
     * 完整流程如下：
     * i=0 nums[i]=4, nums[3]=7 > 0 nums=[4,3,2,-7,8,2,3,1]
     * i=1 nums[i]=3, nums[2]=2 > 0 nums=[4,3,-2,-7,8,2,3,1]
     * i=2 nums[i]=-2 nums[1]=3 > 0 nums=[4,-3,-2,-7,8,2,3,1]
     * i=3 nums[i]=-7 nums[6]=3 > 0 nums=[4,-3,-2,-7,8,2,-3,1]
     * i=4 nums[i]=8 nums[7]=1 > 0 nums=[4,-3,-2,-7,8,2,-3,-1]
     * i=5 nums[i]=2 nums[1]=-3 < 0 nums=[4,-3,-2,-7,8,2,-3,-1]
     * i=6 nums[i]=-3 nums[2]=-2 < 0 nums=[4,-3,-2,-7,8,2,-3,-1]
     * i=7 nums[i]=-1 nums[0]=4 > 0 nums=[4,-3,-2,-7,8,2,-3,-1]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDisappearedNumbers(nums);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
