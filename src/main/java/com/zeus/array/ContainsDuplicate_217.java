package com.zeus.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuxingbo
 * @Date 2018/3/18
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate_217 {
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<Integer>();
        for(int value : nums){
            if(numbers.contains(value)){
                return true;
            }
            numbers.add(value);
        }
        return false;
    }
}
