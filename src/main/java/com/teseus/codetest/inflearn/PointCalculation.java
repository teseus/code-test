package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// 직관적을 풀었고, 1차에서 통과 , 해설을 참고해서 한번더 최적화

public class PointCalculation {
    static class Solution {
        public int solution(int[] n) {
            int count = 0;
            int previous = 0;
            for (int i = 0; i < n.length; i++) {
                if(n[i] == 1) {
                        previous++;
                        count += previous;
                } else {
                    previous = 0;
                }
            }
            return count;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] nums = new int[input1];
        for (int i = 0; i < input1; i++) {
            nums[i] = in.nextInt();
        }
        int count = new Solution().solution(nums);
        System.out.println(count);
    }

    @Test
    public void test1(){
        //when
        int result3 = new Solution().solution(new int[]{0,0,0,0,0,0,0,0,1,1});
        //then
        Assert.assertEquals(3, result3);
        //when
        int result5 = new Solution().solution(new int[]{1});
        //then
        Assert.assertEquals(1, result5);
        //when
        int result4 = new Solution().solution(new int[]{1,0,1,0,1,0,1,0,1,0});
        //then
        Assert.assertEquals(5, result4);
        //when
        int result2 = new Solution().solution(new int[]{1,0,1,1,1,0,0,1,1,0});
        //t result2 = new Solution().solution(new int[]{1,0,1,2,3,0,0,1,2,0});
        //then
        Assert.assertEquals(10, result2);
        //when
        int result = new Solution().solution(new int[]{1,0,1,1,1,0,0,1,1,0});
        //then
        Assert.assertEquals(10, result);
    }
}