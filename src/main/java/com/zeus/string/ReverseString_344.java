package com.zeus.string;

import org.junit.Test;

import java.util.Collections;

/**
 * @author xuxingbo
 * @Date 2018/3/21
 *
 * 344. Reverse String
 *
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int i = 0, j = s.length()-1;
        while(i < j){
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        return new String(charArray);
    }
    
    public String reverseString2(String s){
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < split.length;i++){
            sb.append(reverseString(split[i]));
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length()-1);
    }
    @Test
    public void test(){
        String s = "Let's take LeetCode contest";
        System.out.println(reverseString2(s));
    }
}
