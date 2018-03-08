package com.zeus;

import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/8
 * Leetcode 6：ZigZag Conversion
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i =0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        int cur = 0;
        while( cur < s.length() ){
            for(int j = 0; j < numRows && cur < s.length(); j++) //直线向下
                sb[j].append(s.charAt(cur++));
            for(int j = numRows-2; j >0 && cur < s.length(); j--) //斜线向上
                sb[j].append(s.charAt(cur++));
        }
        
        for(int i = 1; i < numRows;i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
    
    @Test
    public void test(){
        System.out.println(convert("PAYPALISHIRING", 3));
    }
    
}
