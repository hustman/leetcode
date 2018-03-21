package com.zeus.string;

/**
 * @author xuxingbo
 * @Date 2018/3/21
 *
 * 657. Judge Route Circle
 *
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
 * judge if this robot makes a circle, which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character.
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 * The output should be true or false representing whether the robot makes a circle.
 */
public class JudgeRouteCircle_657 {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        for(char c : moves.toCharArray()){
            switch(c){
                case 'R':
                    col++;
                    break;
                case 'L':
                    col--;
                    break;
                case 'U':
                    row++;
                    break;
                case 'D':
                    row--;
                    break;
                default:
                    break;
            }
        }
        return row == 0 && col == 0;
    }
}
