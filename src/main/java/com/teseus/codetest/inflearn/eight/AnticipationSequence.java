package com.teseus.codetest.inflearn.eight;

import org.junit.Test;

import java.util.Scanner;

// 1차로 풀었음.

public class AnticipationSequence {
    static class Solution {
        int[][] matrix;
        public void solution(int num, int sum) {
            matrix = new int[num][num];
        }

        private int makeCombinationMatrix(int num, int re) {
            if(matrix[num][re] > 0){
                return matrix[num][re];
            }
            if(num == re || re == 0) {
                return 1;
            } else {
                return matrix[num][re] = makeCombinationMatrix(num-1, re-1) + makeCombinationMatrix(num-1, re);
            }
        }
    }

    @Test
    public void test1(){
        //when
        new Solution().solution(4, 16);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        int sum = in.nextInt();
        new Solution().solution(num, sum);
    }
}