package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinarayTreeTraverse {
    static class Solution {
        public List<Integer> solution(int[] n) {
            return Arrays.asList(1);
        }
    }

    @Test
    public void test1(){
        //when
        List<Integer> result = new Solution().solution(new int[]{1,3});
        //then
        Assert.assertEquals(Arrays.asList(1,2,4,5,3,6,7), result);
    }
}