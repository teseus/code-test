package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1st success

public class IslandBFS {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Solution {
        int[][] board;
        int answer = 0;
        int length = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<Point> queue = new LinkedList<>();

        public int solution(int[][] board) {
            this.board = board;
            this.length = board.length;
            for (int x = 0; x < length; x++) {
                for (int y = 0; y < length; y++) {
                    if (board[x][y] == 1) {
                        answer++;
                        board[x][y] = 0;
                        queue.offer(new Point(x, y));
                        bfs();
                        printBoard(board);
                    }
                }
            }
            return answer;
        }

        private void bfs() {
            while (!queue.isEmpty()) {
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    Point point = queue.poll();
                    for (int j = 0; j < dx.length; j++) {
                        int nx = point.x + dx[j];
                        int ny = point.y + dy[j];
                        if (0 <= nx && nx < length && 0 <= ny && ny < length && board[nx][ny] == 1) {
                            board[nx][ny] = 0;
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }

        private void printBoard(int[][] board) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[0].length; y++) {
                    System.out.print(String.format("%2d ", board[x][y]));
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[][] board = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = in.nextInt();
            }
        }
        System.out.println(new Solution().solution(board));
    }

    @Test
    public void test1() {
        //given
        int[][] board4 = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        //when
        int ans4 = new Solution().solution(board4);
        //then
        Assert.assertEquals(0, ans4);
        //given
        int[][] board3 = {
                {1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 1}
        };
        //when
        int ans3 = new Solution().solution(board3);
        //then
        Assert.assertEquals(1, ans3);
        //given
        int[][] board2 = {
                {1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1}
        };
        //when
        int ans2 = new Solution().solution(board2);
        //then
        Assert.assertEquals(4, ans2);
        //given
        int[][] board1 = {
                {1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}
        };
        //when
        int ans1 = new Solution().solution(board1);
        //then
        Assert.assertEquals(5, ans1);
    }
}