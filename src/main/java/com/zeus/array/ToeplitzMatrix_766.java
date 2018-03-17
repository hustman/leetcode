package com.zeus.array;

/**
 * @author xuxingbo
 * @Date 2018/3/15
 * 简单的问题，不要复杂化
 */
public class ToeplitzMatrix_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i =0 ; i < matrix.length-1; i++){
            for(int j = 0; j < matrix[0].length-1; j++){
                if(matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }
}
