package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

// 직관적으로 풀었으나 fail 이 난다. 문제를 잘못이해한 건지.. 알 수없다. 분명히 4번학생이 3명 중복인데.. 3번 학생이라네.. 알수없다.

public class TemporaryLeader {
    static class Solution {
        public int solution(int[][] matrix) {
            int len = matrix.length;
            int[][] counts = new int[len][5];
            for (int x = 0; x < len; x++) {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        if (i != j && matrix[i][x] == matrix[j][x]) {
                            counts[i][x] = 1;
                        }
                    }
                }
            }
            System.out.println("counts = " + Arrays.deepToString(counts));
            int max = 0;
            int maxIdx = -1;
            for (int y = 0; y < len; y++) {
                int count = 0;
                for (int x = 0; x < len; x++) {
                    count += counts[y][x];
                }
                System.out.println(y + ":count = " + count);
                if(count> max) {
                    max = count;
                    maxIdx = y;
                    System.out.println("maxIdx = " + maxIdx);
                }
            }
            return maxIdx+1;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int dimension = in.nextInt();
        int[][] matrix = new int[dimension][5];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int count = new Solution().solution(matrix);
        System.out.println(count);
    }

    @Test
    public void test1(){
        //given:
        int[][] matrix2 = {
                {9, 8, 7, 6, 5},
                {5, 6, 7, 8, 9},
                {1, 2, 3, 7, 8},
                {4, 5, 3, 4, 2},
                {6, 2, 8, 4, 2},
        };
        //when
        int result2 = new Solution().solution(matrix2);
        //then
        Assert.assertEquals(3, result2);

        //given:
        int[][] matrix1 = {
                {5, 4, 4, 2, 1},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 7, 8}
        };
        //when
        int result1 = new Solution().solution(matrix1);
        //then
        Assert.assertEquals(2, result1);

        //given:
        int[][] matrix = {
                {2, 3, 1, 7, 3},
                {4, 1, 9, 6, 8},
                {5, 5, 2, 4, 4},
                {6, 5, 2, 6, 7},
                {8, 4, 2, 2, 2}
        };
        //when
        int result = new Solution().solution(matrix);
        //then
        Assert.assertEquals(4, result);
    }
}