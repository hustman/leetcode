package com.zeus.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxingbo
 * @Date 2018/3/22
 */
public class RotatedDigits_788 {
    public int rotatedDigits(int N) {
        Map<Character,Character> maps = new HashMap<Character,Character>();
        maps.put('2','5');maps.put('5','2');
        maps.put('6','9');maps.put('9','6');
        int count = 0;
        for(int i = 1; i < N; i++){
            count += isGoodNum(String.valueOf(i), maps);
        }
        return count;
    }
    
    private int isGoodNum(String s, Map<Character,Character> maps){
        int common = 0;
        for(char c : s.toCharArray()){
            Character value = maps.get(c);
            if(value == null){
                return 0;
            }
            if(value == c){
                common++;
            }
        }
        return common == s.length() ? 0 : 1;
    }
}
