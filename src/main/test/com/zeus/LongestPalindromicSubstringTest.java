package com.zeus;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2017/9/14
 */
public class LongestPalindromicSubstringTest {

    private String case1 = "babad";
    private String case2 = "baab";
    @Test
    public void longestPalindaromicSubstring() throws Exception {
        String result1 = LongestPalindromicSubstring.longestPalindaromicSubstring(case1);
        Assert.assertEquals(result1,"bab");

        String result2 = LongestPalindromicSubstring.longestPalindaromicSubstring(case2);
        Assert.assertEquals(result2,"baab");
    }

    @Test
    public void longestPalindaromicSubstring2() throws Exception {
        String result1 = LongestPalindromicSubstring.longestPalindaromicSubstring2(case1);
        Assert.assertEquals(result1,"bab");

        String result2 = LongestPalindromicSubstring.longestPalindaromicSubstring(case2);
        Assert.assertEquals(result2,"baab");
    }

}