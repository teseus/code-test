package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// 직관적으로 프라임 넘버를 2중 for 문으로 처리했느나, 시간이 초과됨.

public class PrimeNumberEratos {
    static class Solution {
        public int solution(int n) {
            int count = 0;
            if(n<2) {
                return 0;
            }
            for (int i = 2; i <= n; i++) {
                if(isPrime(i)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isPrime(int num) {
            for (int i = 2; i < num; i++) {
                if(num%i == 0){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int count = new Solution().solution(input1);
        System.out.println(count);
    }

    @Test
    public void test1(){
        //when
        int result5 = new Solution().solution(3);
        //then
        Assert.assertEquals(2, result5);
        //when
        int result4 = new Solution().solution(1);
        //then
        Assert.assertEquals(0, result4);
        //when
        int result3 = new Solution().solution(0);
        //then
        Assert.assertEquals(0, result3);
        //when
        int result2 = new Solution().solution(8);
        //then
        Assert.assertEquals(4, result2);
        //when
        int result = new Solution().solution(20);
        //then
        Assert.assertEquals(8, result);
    }
}