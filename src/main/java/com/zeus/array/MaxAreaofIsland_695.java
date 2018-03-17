package com.zeus.array;

import org.junit.Test;

/**
 * @author xuxingbo
 * @Date 2018/3/16
 */
public class MaxAreaofIsland_695 {
    private int row;
    private int col;
    private boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int max = 0;
        visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j< col; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    max = Math.max(max, dfs(grid,i,j));
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j){
        if(i >= 0 && i < row && j >= 0 && j < col && !visited[i][j] && grid[i][j] == 1){
            visited[i][j] = true;
            return 1 + dfs(grid,i-1,j) + dfs(grid,i+1,j) + dfs(grid,i,j-1) + dfs(grid,i,j+1);
        }
        return 0;
    }
    
    @Test
    public void test(){
        int[][] grid = new int[][]
                {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
