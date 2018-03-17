package com.zeus.array;

import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/15
 */
public class ReshapetheMatrix_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if( row * col != r * c || (row == r && col ==c)){
            return nums;
        }
        int[][] result = new int[r][c];
        int index = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                result[i][j] = nums[index / col][index % col];
                index++;
            }
        }
        return result;
    }
    
    @Test
    public void test(){
        int[][] nums = new int[][]{{1,2},{3,4}};
        int r = 2;
        int c = 2;
        int[][] result = matrixReshape(nums,r,c);
        for(int i =0; i < result.length; i++){
            for(int j =0 ;j < result[i].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
