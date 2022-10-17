package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

// 일단 생각 나는데로 작성했다. 그런데 틀렸다.

public class Fibonacci {
    class Solution {
        public int solution(int n) {
            if(n<2){
                return n;
            }
            int sum0= 0;
            int sum1 = 1;
            int sum = 0;
            for (int i = 2; i <= n; i++) {
                sum = sum0 + sum1;
                sum0 = sum1;
                sum1 = sum;
            }
            return sum;
        }
    }

    @Test
    public void test1(){
        //when
        int result6 = new Solution().solution(2);
        //then
        Assert.assertEquals(1, result6);
        //when
        int result5 = new Solution().solution(1);
        //then
        Assert.assertEquals(1, result5);
        //when
        int result4 = new Solution().solution(0);
        //then
        Assert.assertEquals(0, result4);
        //when
        int result3 = new Solution().solution(6);
        //then
        Assert.assertEquals(8, result3);
        //when
        int result2 = new Solution().solution(4);
        //then
        Assert.assertEquals(3, result2);
        //when
        int result = new Solution().solution(5);
        //then
        Assert.assertEquals(5, result);
        //when
        int result1 = new Solution().solution(3);
        //then
        Assert.assertEquals(2, result1);
    }}