package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class GreedyTemplate {
    static class Solution {
        public int solution(int[] n) {
            return 0;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        int count = new Solution().solution(nums);
        System.out.println(count);
    }

    @Test
    public void test1(){
        //when
        int result = new Solution().solution(new int[]{1,3});
        //then
        Assert.assertEquals(2, result);
    }
}