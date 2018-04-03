package com.zeus.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/31
 */
public class ReverseString_II_541 {
    public String reverseStr(String s, int k) {
        boolean flag = true;
        int i = 0;
        int j = k;
        StringBuffer sb = new StringBuffer();
        while(i < s.length() && j <= s.length()){
            String temp = flag ? reverse(s.substring(i,j)) : s.substring(i,j);
            sb.append(temp);
            flag = !flag;
            i = j;
            j += k;
        }
        if(i < s.length() && j > s.length()){
            String temp = flag ? reverse(s.substring(i)) : s.substring(i);
            sb.append(temp);
        }
        return sb.toString();
    }
    
    /*
    包含start，但是不包含end
    */
    private String reverse(String s){
        char[] strs = s.toCharArray();
        int i = 0, j = s.length()-1;
        while(i < j){
            char temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
            i++;j--;
        }
        return new String(strs);
    }
    
    @Test
    public void test(){
        String str = "abcdefgh";
        int k = 2;
        Assert.assertEquals(reverseStr(str,k), "bacdfegh");
    }
}
