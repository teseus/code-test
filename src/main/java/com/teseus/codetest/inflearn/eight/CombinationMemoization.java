package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// 1차로 풀었음.

public class CombinationMemoization {
    static class Solution {
        int[][] matrix;
        public int solution(int n, int r) {
            this.matrix = new int[n+1][r+1];
            return dfs(n, r);
        }

        private int dfs(int n, int r) {
            if(matrix[n][r] > 0) {
                return matrix[n][r];
            }
            if(n == r || r ==0) {
                return 1;
            } else {
                return matrix[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
            }
        }
    }

    @Test
    public void test1(){
        //when
        int ret = new Solution().solution(5, 3);
        //then
        Assert.assertEquals(10, ret);
        //when
        int ret2 = new Solution().solution(33, 19);
        //then
        Assert.assertEquals(818809200, ret2);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        System.out.println(new Solution().solution(n, r));
    }
}