package com.teseus.codetest.inflearn.seven;

import org.junit.Assert;
import org.junit.Test;

public class SearchPath {
    static class Solution {
        private int [][] matrix;
        private int [] check;
        private int len = 0;
        private int count = 0;
        public int solution(int nodeCount, int[][] matrix) {
            this.matrix = matrix;
            this.len = nodeCount;
            this.check = new int[len+1];

            dfs(1);
            return this.count;
        }

        private void dfs(int nodeNum) {
            if(nodeNum == len) {
                count++;
                return;
            }
            for (int i = 0; i < len; i++) {
                if(check[i] != 1) {
                    dfs(i);
                } else {

                }
            }
        }
    }

    @Test
    public void test1(){
        //when
        int result = new Solution().solution(5,
                new int[][]{{5,9}, {1,2}, {1,3}, {1,4}, {2,1}, {2,3}, {2,5}, {3,4}, {4,2}, {4,5}});
        //then
        Assert.assertEquals(6, result);
    }
}