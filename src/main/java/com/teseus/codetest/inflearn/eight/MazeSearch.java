package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

// 1st success

public class MazeSearch {
    static class Solution {
        int[][] board;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int answer = 0;
        public int solution(int[][] board) {
            this.board = board;
            board[1][1] = 1;
            dfs(1,1);
            return answer;
        }

        private void dfs(int x, int y) {
            if(x==7 && y==7){
                for (int i = 1; i < 8; i++) {
                    System.out.println(Arrays.toString(board[i]));
                }
                System.out.println();

                answer++;
            } else {
                for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                    if (1<=nx && nx<=7 && 1<=ny && ny<=7 && board[nx][ny] == 0 ) {
                        board[nx][ny] = 9;
                        dfs(nx, ny);
                        board[nx][ny] = 0;
                    }
                }
            }
        }
    }

    @Test
    public void test1(){
        int[][] board = {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,1,0},
                {0,0,0,0,1,0,0,0},
                {0,1,1,0,1,0,1,1},
                {0,1,1,0,0,0,0,1},
                {0,1,1,0,1,1,0,0},
                {0,1,0,0,0,0,0,0}
        };
        //when
        int ans = new Solution().solution(board);
        //then
        Assert.assertEquals(8, ans);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        int sum = in.nextInt();
    }
}