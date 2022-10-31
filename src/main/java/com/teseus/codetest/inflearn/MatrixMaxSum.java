package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

//처음에 직관적으로 풀었으나 에러 이유는 문제를 잘못이해해서 루프를 i=0 으로 고정해서 하나만 돌았음.
//에러가 나오고 난후 행과 열은 모두다 계산해야 한다는 것을 알고 수정

public class MatrixMaxSum {
    static class Solution {
        public int solution(int[][] matrix) {
            int hol = 0;
            int ver = 0;
            int dia = 0;
            for (int i = 0; i < matrix.length; i++) {
                int x = 0;
                int y = 0;
                for (int j = 0; j < matrix.length; j++) {
                    x += matrix[i][j];
                    y += matrix[j][i];
                }
                hol = Math.max(hol, x);
                ver = Math.max(ver, y);
                dia += matrix[i][i];
            }

//            System.out.println("hol = " + hol + ",ver = " + ver + ",dia = " + dia);
            return Math.max(dia,Math.max(hol,ver));
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
        int[][] matrix = {
                {75, 79, 6 , 72, 40, 72, 28, 43, 64, 19},
                {97, 71, 12, 48, 64, 95, 64, 40, 38, 24},
                {52, 17, 58, 64, 13, 37, 38, 5 , 30, 36},
                {43, 30, 15, 8 , 13, 21, 81, 29, 79, 33},
                {20, 4 , 31, 24, 93, 60, 61, 19, 9 , 88},
                {12, 33, 30, 4 , 38, 62, 98, 34, 65, 33},
                {37, 26, 6 , 60, 82, 57, 49, 85, 66, 67},
                {93, 4 , 29, 67, 65, 96, 5 , 27, 39, 87},
                {16, 52, 8 , 7 , 56, 19, 8 , 53, 52, 93},
                {87, 55, 58, 84, 61, 92, 3 , 74, 66, 34}
        };
        //when
        int result = new Solution().solution(matrix);
        //then
        Assert.assertEquals(614, result);
    }
}