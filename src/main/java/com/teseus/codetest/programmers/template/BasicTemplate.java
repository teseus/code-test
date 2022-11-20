package com.teseus.codetest.programmers.template;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//기본 템플릿이다. 라이프 보트를 복사했다.

public class BasicTemplate {
        class Solution {
            public int solution(int[] people, int limit) {
                Arrays.sort(people);
                int i = 0, j = people.length - 1;
                for (; i < j; --j) {
                    if (people[i] + people[j] <= limit)
                        ++i;
                }
                return people.length - i;
            }
        }

    @Test
    public void test1(){
        //when
        int result3 = new Solution().solution(new int[]{1,2,3,4,5,5,6,7,8,9}, 10);
        //then
        Assert.assertEquals(5, result3);
        //when
        int result2 = new Solution().solution(new int[]{40,40}, 40);
        //then
        Assert.assertEquals(2, result2);
        //when
        int result1 = new Solution().solution(new int[]{70, 80, 50}, 100);
        //then
        Assert.assertEquals(3, result1);
        //when
        int result = new Solution().solution(new int[]{70, 50, 80, 50}, 100);
        //then
        Assert.assertEquals(3, result);
    }
}