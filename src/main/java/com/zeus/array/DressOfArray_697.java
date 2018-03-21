package com.zeus.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuxingbo
 * @Date 2018/3/18
 */
public class DressOfArray_697 {
    
    public int findShortestSubArray(int[] nums) {
        Map<Integer,List<Integer>> maps = new HashMap<Integer,List<Integer>>();
        int degree = 0;
        for(int i = 0; i < nums.length; i++){
            if(!maps.containsKey(nums[i])){
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                maps.put(nums[i], list);
            }else{
                maps.get(nums[i]).add(i);
            }
            if(maps.get(nums[i]).size() > degree){
                degree = maps.get(nums[i]).size();
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : maps.entrySet()) {
            List<Integer> value = entry.getValue();
            if(value.size() == degree){
                int i = value.get(value.size() - 1) - value.get(0);
                if(i < shortest){
                    shortest = i+1;
                }
            }
        }
        return shortest;
    }
    
    @Test
    public void test(){
        int[] nums = new int[]{1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));
    }
}
