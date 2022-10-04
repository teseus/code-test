package com.teseus.codetest;

import org.junit.Assert;
import org.junit.Test;

public class DoublePriorityQueue {
    class Solution {
        public int[] solution(String[] operations) {
            for (String operation : operations) {
                String[] divided = operation.split(" ");
                String op = divided[0];
                String data = divided[1];
            }
            return new int[]{0};
        }
    }

    @Test
    public void test1(){
        //given
        Solution solution = new Solution();
        //when
        String [] arg = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] result = solution.solution(arg);
        //then
        Assert.assertArrayEquals(new int[]{0,0}, result);
    }
}
