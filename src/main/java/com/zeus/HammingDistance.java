package com.zeus;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/8
 * Leetcode 461： Hamming Distance
 */
public class HammingDistance {
    /**
     * 0 < x,y < 2^31
     * @return
     */
    public int hammingDistance(int x, int y) {
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);
        int diff = 0;
        int xLen = xStr.length();
        int yLen = yStr.length();
        while(xLen > 0 && yLen > 0){
            if(xStr.charAt(xLen-1) != yStr.charAt(yLen-1)){
                diff++;
            }
            xLen--;
            yLen--;
        }
        while(xLen > 0){
            if(xStr.charAt(xLen-1) == '1'){
                diff++;
            }
            xLen--;
        }
        while(yLen > 0){
            if(yStr.charAt(yLen-1) == '1'){
                diff++;
            }
            yLen--;
        }
        return diff;
    }
    
    
    public int hammingDistance1(int x, int y){
        int diff = 0;
        int n = x ^ y; // the difference
        while( n > 0 ){
            diff++;
            n = n & (n-1);  // how much 1 in n
        }
        return diff;
    }
    
    @Test
    public void test(){
        System.out.println(hammingDistance(1,4));
        System.out.println(hammingDistance(1,1));
        System.out.println(hammingDistance(93,73));
    
        Assert.assertEquals(hammingDistance(1,4), hammingDistance1(1,4));
        Assert.assertEquals(hammingDistance(1,1), hammingDistance1(1,1));
        Assert.assertEquals(hammingDistance(93,73), hammingDistance1(93,73));
    }
    
}
