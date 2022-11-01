package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

//그냥 직관적으로 풀었고 패스 됐음.

public class Peak {
    static class Solution {
        public int solution(int[][] matrix) {
            int length = matrix.length;
            int count = 0;
            for (int x = 0; x < length; x++) {
                for (int y = 0; y < length; y++) {
                    //상
                    int up;
                    if(y==0) {
                        up = 0;
                    } else {
                        up = matrix[y-1][x];
                    }
                    //하
                    int down;
                    if(y==length-1) {
                        down = 0;
                    } else {
                        down = matrix[y + 1][x];
                    }
                    //좌
                    int left;
                    if(x==0) {
                        left = 0;
                    } else {
                        left = matrix[y][x - 1];
                    }
                    //우
                    int right;
                    if(x==length-1){
                        right = 0;
                    } else {
                        right = matrix[y][x + 1];
                    }
                    //센터
                    int center = matrix[y][x];
                    if(center > up && center > down && center > left && center > right) {
                        count++;
//                        System.out.println("peak count = " + count + ", x:" + x + ", y:" + y);
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int dimension = in.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int count = new Solution().solution(matrix);
        System.out.println(count);
    }

    @Test
    public void test1(){
        int[][] matrix3 = {
                {1, 1},
                {1, 1},
        };
        //when
        int result3 = new Solution().solution(matrix3);
        //then
        Assert.assertEquals(0, result3);

        int[][] matrix2 = {
                {1, 0, 0, 0, 3},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {8, 0, 0, 0, 2},
        };
        //when
        int result2 = new Solution().solution(matrix2);
        //then
        Assert.assertEquals(4, result2);
        int[][] matrix = {
                {5, 3, 7, 2, 3},
                {3, 7, 1, 6, 1},
                {7, 2, 5, 3, 4},
                {4, 3, 6, 4, 1},
                {8, 7, 3, 5, 2}
        };
        //when
        int result = new Solution().solution(matrix);
        //then
        Assert.assertEquals(10, result);
    }
}