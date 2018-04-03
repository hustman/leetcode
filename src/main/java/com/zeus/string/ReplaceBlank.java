package com.zeus.string;

import org.junit.Assert;
import org.junit.Test;

import javax.print.attribute.standard.RequestingUserName;

/**
 * @author xuxingbo
 * @Date 2018/3/22
 */
public class ReplaceBlank {
    
    public String solution(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    @Test
    public void test(){
        String str = "We are Happy";
        Assert.assertEquals(solution(str), str.replace(" ", "%20"));
    }
}
