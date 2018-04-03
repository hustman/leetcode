package com.zeus.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/17
 * 717. 1-bit and 2-bit Characters
 * We have two special characters. The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits.
 * Return whether the last character must be a one-bit character or not.
 * The given string will always end with a zero.
 */
public class OneOrTwoBitCharacters_717 {
    /**
     * 解法1，字面意思很好理解
     * 从左向右遍历，如果是0，就检查下一个；如果是1，就跳过下一个，检查下下一个
     * 由于最后一位是0，所以最后一步如果执行了i++操作，那么i==size,最后返回True
     * 如果执行了i+2操作，那么说明跳过了最后一位，即i!=size，最后返回false
     */
    public boolean isOneBitCharacter1(int[] bits) {
        int size = bits.length - 1, i = 0;
        while (i < size) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == size;
    }
    
    /**
     * 解法2， 从右向左遍历
     * 最后一位如果不是0，那么该穿一定是一个tow-bit，因此最后一位一定是0（正如题目中所强调的）
     * 最后一位一定是0，那么我们可以从倒数第二位开始起，判断其前面有多少个连续的1
     * 如果有偶数个连续1，那么前面的偶数个1可以组成若干个two-bits，最后一个0，只能说明该字符串为一个one-bit
     * 如果有奇数个连续1，连续1的前面要么为空，要么为0，由于01不符合规则，因此只能这奇数个1 + 最后的0 组成规则
     * 因此最后一个Character必定是一个two-bit的10，所以该字符串为一个two-bits
     * 综上所述：前面有连续偶数个1==>one-bit,前面有连续奇数个1==>two-bits
     */
    public boolean isOneBitCharacter2(int[] bits){
        int one = 0;
        for(int i = bits.length -2; i >= 0 && bits[i] != 0; i--){
            one++;
        }
        return (one % 2) == 0;
    }
    
    public boolean isOneBitCharacter3(int[] bits) {
        int count = 0;
        for(int i = bits.length-2; i >= 0; i--){
            if(bits[i] == 1){
                count++;
            }else{
                break;
            }
        }
        return count % 2 == 0;
    }
    
    @Test
    public void test(){
        int[] bits = new int[]{1,0,0};
        Assert.assertTrue(isOneBitCharacter1(bits));
        Assert.assertTrue(isOneBitCharacter2(bits));
        
        bits = new int[]{1,1,1,0};
        Assert.assertFalse(isOneBitCharacter1(bits));
        Assert.assertFalse(isOneBitCharacter2(bits));
        
        
        Assert.assertFalse(isOneBitCharacter3(bits));
    }
}
