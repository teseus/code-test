package com.teseus.codetest.common;

import org.junit.Assert;
import org.junit.Test;


public class BasicTemplate2DArray {
    class Solution {
        public int solution(int[][] accounts) {
            return 0;
        }
    }

    @Test
    public void test1(){
        //given
        Solution solution = new Solution();
        //when
        int[][] arg = {{1, 2}, {3, 4}};
        int result = solution.solution(arg);
        //then
        Assert.assertEquals(0, result);
    }
}