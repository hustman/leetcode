package com.zeus.string;

/**
 * @author xuxingbo
 * @Date 2018/3/22
 */
public class DetectCapital_520 {
    public boolean detectCapitalUse(String word) {
        final char MIN_CHAR = 'A';
        final char MAX_CHAR = 'Z';
        int count = 0;
        boolean firstUppder = false;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) >= MIN_CHAR && word.charAt(i) <= MAX_CHAR){
                count++;
                if(i == 0){
                    firstUppder = true;
                }
                continue;
            }
            if(count > 1){
                return false;
            }
        }
        boolean allLowLetter = count == 0;
        boolean firstUpperLetter = firstUppder && count == 1;
        boolean allUpperLetter = count == word.length();
        return allLowLetter || firstUpperLetter || allUpperLetter;
    }
}
