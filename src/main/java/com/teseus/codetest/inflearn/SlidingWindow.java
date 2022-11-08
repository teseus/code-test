package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// 직관적으로 풀어서 해결했다.

public class SlidingWindow {
    static class Solution {
        public int solution(int len, int span, int[] arr) {
            int max = 0;
            for (int i = 0; i < span; i++) {
                max += arr[i];
            }
            int temp = max;
            for (int i = 1; i <= (len-span); i++) {
                temp = temp - arr[i-1] + arr[i+span-1];
//                System.out.println("i = " + i + ", max = " + max
//                                + ", arr[i-1] = " + arr[i-1]  + ", arr[i+span-1] = " + arr[i+span-1]
//                                + ", temp = " + temp);
                max = Math.max(temp, max);
            }
            return max;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int span = in.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        int count = new Solution().solution(len, span, nums);
        System.out.println(count);
    }

    @Test
    public void test1(){
        //when
        int result1 = new Solution().solution(10, 3, new int[] {12, 15,11, 20, 25,10, 20, 19, 13, 15});
        //then
        Assert.assertEquals(56, result1);
        //when
        int result = new Solution().solution(10, 3, new int[] {12, 15, 11, 20, 25, 10, 20, 19, 13, 15});
        //then
        Assert.assertEquals(56, result);
    }
}