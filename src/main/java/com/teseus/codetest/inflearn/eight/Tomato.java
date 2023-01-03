package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1st success

public class Tomato {
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
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Point> queue = new LinkedList<>();

        public int solution(int[][] board) {
            this.board = board;
            int answer = 0;
            int ex = board.length;
            int ey = board[0].length;
            int notCount = 0, count = 0;
            for (int x = 0; x < ex; x++) {
                for (int y = 0; y < ey; y++) {
                    if(board[x][y] == 1){
                        queue.offer(new Point(x, y));
                    }
                    if(board[x][y]==0){
                        notCount++;
                    }
                    if(board[x][y]==1){
                        count++;
                    }
                }
            }
            if(count == 0) {
                return -1;
            }

            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    Point point = queue.poll();
                    for (int j = 0; j < 4; j++) {
                        int nx = point.x + dx[j];
                        int ny = point.y + dy[j];
                        if (0<=nx && nx<ex && 0<=ny && ny<ey && board[nx][ny]==0) {
                            board[nx][ny] = 1;
                            queue.offer(new Point(nx, ny));
                            flag = true;
                            notCount--;
                        }
                    }
                }
                if(flag) {
                    answer++;
                }
            }
            if(notCount != 0) {
                return -1;
            }
            return answer;
        }

        private void printBoard(int[][] board) {
            for (int x = 1; x < board.length; x++) {
                for (int y = 1; y < board[0].length; y++) {
                    System.out.print(String.format("%2d ", board[x][y]));
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        int x = in.nextInt();
        int[][] board = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = in.nextInt();
            }
        }
        System.out.println(new Solution().solution(board));
    }

    @Test
    public void test1() {
        //given
        int[][] board5 = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
        };
        //when
        int ans5 = new Solution().solution(board5);
        //then
        Assert.assertEquals(0, ans5);
        //given
        int[][] board4 = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
        //when
        int ans4 = new Solution().solution(board4);
        //then
        Assert.assertEquals(5, ans4);
        //given
        int[][] board3 = {
                {0, 0, 0, -1, 0, 0},
                {0, 0, -1, 1, -1, 0},
                {0, 0, 0, -1, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
        //when
        int ans3 = new Solution().solution(board3);
        //then
        Assert.assertEquals(-1, ans3);
        //given
        int[][] board2 = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
        //when
        int ans2 = new Solution().solution(board2);
        //then
        Assert.assertEquals(-1, ans2);
        //given
        int[][] board1 = {
                {0, 0, -1, 0, 0, 0},
                {0, 0, 1, 0, -1, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, 0, 0, -1, 1},
        };
        //when
        int ans1 = new Solution().solution(board1);
        //then
        Assert.assertEquals(4, ans1);
    }
}