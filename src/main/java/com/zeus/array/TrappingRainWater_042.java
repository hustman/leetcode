package com.zeus.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/4/7
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算下雨之后能接多少雨水。
 * 例如,
 * 输入 [0,1,0,2,1,0,1,3,2,1,2,1]，返回 6。
 */
public class TrappingRainWater_042 {
    
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int maxArea = 0, maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                maxArea += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                maxArea += maxRight - height[right];
                right--;
            }
        }
        return maxArea;
    }
    
    
    public int trap1(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int maxArea = 0, leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]); // 当前位置的左边最高值
            rightMax = Math.max(rightMax, height[right]); //当前位置的右边最高值
            //能积多少水，主要取决于左右最高中的最小值
            if (leftMax <= rightMax) {
                maxArea += leftMax - height[left];
                left++;
            } else {
                maxArea += rightMax - height[right];
                right--;
            }
        }
        return maxArea;
    }
    
    @Test
    public void test() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assert.assertEquals(6, trap(height));
        
        Assert.assertEquals(6, trap1(height));
    }
}
