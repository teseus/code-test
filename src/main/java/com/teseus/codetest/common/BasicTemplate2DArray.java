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
        //when
        int result = new Solution().solution(new int[][]{{1, 2}, {3, 4}});
        //then
        Assert.assertEquals(0, result);
    }
}