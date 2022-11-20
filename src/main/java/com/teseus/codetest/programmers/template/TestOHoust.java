package com.teseus.codetest.programmers.template;

import org.junit.Assert;
import org.junit.Test;

//기본 템플릿이다. 라이프 보트를 복사했다.

public class TestOHoust {
        class Solution {
            public int[] solution(int[][] v) {
                int[] answer = {};
                return answer;
            }
        }

    @Test
    public void test1(){
        //when
        int[] result3 = new Solution().solution(new int[][]{{1}, {2}});
        //then
        Assert.assertArrayEquals(new int[]{}, result3);
    }
}