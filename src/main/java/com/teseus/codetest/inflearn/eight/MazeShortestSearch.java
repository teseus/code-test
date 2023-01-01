package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1st success

public class MazeShortestSearch {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Solution {
        int[][] board;
        int[][] dis = new int[8][8];
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        Queue<Point> queue = new LinkedList<>();
        public int solution(int[][] board) {
            this.board = board;
            board[1][1] = 1;
            queue.offer(new Point(1,1));
            while (!queue.isEmpty()) {
                Point one = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = one.x + dx[i];
                    int ny = one.y + dy[i];
                    if(1<=nx && nx<=7 && 1<=ny && ny<=7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        dis[nx][ny] = dis[one.x][one.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            return dis[7][7]!=0?dis[7][7]:-1;
        }
    }

    @Test
    public void test1(){
        int[][] board1 = {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,1,0},
                {0,0,0,0,1,0,0,0},
                {0,1,1,0,1,0,1,1},
                {0,1,1,0,0,0,0,1},
                {0,1,1,0,1,1,1,1},
                {0,1,0,0,0,0,1,0}
        };
        //when
        int ans1 = new Solution().solution(board1);
        //then
        Assert.assertEquals(-1, ans1);

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
        Assert.assertEquals(12, ans);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        int sum = in.nextInt();
    }
}