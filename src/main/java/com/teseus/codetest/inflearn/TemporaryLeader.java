package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class TemporaryLeader {
    static class Solution {
        public int solution(int[][] matrix) {
            int len = matrix.length;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if(matrix[0][i]==matrix[0][j]){

                    }
                }
            }
            return 0;
        }
    }

    @Test
    public void test1(){
        int[][] matrix = {
                {2, 3, 1, 7, 3},
                {4, 1, 9, 6, 8},
                {5, 5, 2, 4, 4},
                {6, 5, 2, 6, 7},
                {8, 4, 2, 2, 2}
        };
        //when
        int result = new Peak.Solution().solution(matrix);
        //then
        Assert.assertEquals(4, result);
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

        int count = new Peak.Solution().solution(matrix);
        System.out.println(count);
    }
}