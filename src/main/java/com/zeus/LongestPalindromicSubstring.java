package com.zeus;

/**
 * @author xuxingbo
 * @Date 2017/9/14
 * 三种解法
 * 1. 暴力破解法，求出字符串的所有子串，逐一进行计算，判断最大回文子串 时间复杂度为O(n^3)
 * 2. 中心节点法，以每个字符为中心节点，向四周进行扩散 时间复杂度为O(n^2)
 * 3. Manacher算法，时间复杂度为O(n)
 */
public class LongestPalindromicSubstring {

    /**
     * Manacher算法求最长回文子串问题
     * 详细解题步骤见 https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.05.md
     */
    public static String longestPalindaromicSubstring(String source){
        //转变
        String target = process(source);
        int[] p = new int[target.length()];
        //最大回文中间点位置，以及最大点位置
        int mx = 0, id = 0;
        for (int i = 1; i < target.length()-1; i++) {
            //p[i]为字符串中以i为中心的回文子串向左或向右扩张的长度
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 0;
            while(target.charAt(i + 1 + p[i]) == target.charAt(i -1 - p[i]))
                p[i]++;
            //只有当回文串的长度大于当前的最大长度后，才进行替换
            if(p[i] > mx - id && i + p[i] > mx){
                mx = i + p[i];
                id = i;
            }
        }
        String result = target.substring(2 * id -mx, mx);
        return result.replaceAll("#","");
    }

    /**
     * 利用中心对称法，以每一个字符为中心，逐渐向外扩散，找到最长的回文子串
     */
    public static String longestPalindaromicSubstring2(String source){
        String target = process(source);
        int redius = 0, center =0;
        for (int i = 1; i < target.length() -1 ; i++) {
            int current = 0;
            while(target.charAt(i + current + 1) == target.charAt(i - current -1))
                current++;
            if(current > redius){
                redius = current;
                center = i;
            }
        }
        String result = target.substring(center-redius, center + redius);
        return result.replaceAll("#","");
    }

    private static String process(String str){
        //将整个求解的字符串转变为一个长度为奇数的串
        char[] t = new char[str.length() * 2 + 3];
        //收尾设置特殊字符，可以避免处理数组的越界问题
        t[0] = '$';
        t[str.length() * 2 + 2] = '@';
        for(int i = 0; i < str.length(); i++){
            t[2*i + 1] = '#';
            t[2 * i + 2] = str.charAt(i);
        }
        t[str.length() * 2 + 1] = '#';
        return new String(t);
    }
}
