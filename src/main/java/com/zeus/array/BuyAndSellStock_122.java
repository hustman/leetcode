package com.zeus.array;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author xuxingbo
 * @Date 2018/3/17
 * 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BuyAndSellStock_122 {
    /**
     * 常规方法，直接找到数组中的所有最长递增子序列段
     * 然后将各个段的差值累加起来
     */
    public int maxProfit(int[] prices) {
        int profile = 0;
        for(int i =0 ; i < prices.length-1;i++){
            int start = i;
            while(start < prices.length-1){
                if(prices[start] > prices[start+1]){
                    break;
                }
                start++;
            }
            profile += prices[start]-prices[i];
            i = start;
        }
        return profile;
        
    }
    
    @Test
    public void test(){
        int[] prices = new int[]{3,2,6,5,9};
        Assert.assertEquals(maxProfit(prices), 8);
    }
}
