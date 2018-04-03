package com.zeus.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/28
 */
public class MinCostClimbingStair_746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] temp = new int[cost.length];
        temp[0] = cost[0];
        temp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            temp[i] = Math.min(temp[i - 1], temp[i - 2]) + cost[i];
        }
        return Math.min(temp[cost.length - 1], temp[cost.length - 2]);
    }
    
    @Test
    public void test() {
        //int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = new int[]{10, 15, 20};
        Assert.assertEquals(minCostClimbingStairs(cost), 15);
        
        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        Assert.assertEquals(minCostClimbingStairs(cost), 6);
    }
}
