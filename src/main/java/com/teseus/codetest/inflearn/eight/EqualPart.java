package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

// 일반적인 그래프 알고리즘으로 풀었으며 1차에 성공

public class EqualPart {
    static class Solution {
        private int[] check;
        private int sum;
        private int[] array;

        public boolean solution(int[] array) {
            this.sum = Arrays.stream(array).sum();
            if(sum%2==1) {
                return false;
            }
            check = new int[array.length];
            this.array = array;
            check[0] = 1;
            boolean result = dfs(array[0]);
            return result;
        }

        private boolean dfs(int subSum) {
            if(isSame(subSum)) {
                return true;
            }
            for (int i = 0; i < array.length; i++) {
                if(check[i] == 0) {
                    check[i] = 1;
                    boolean ret = dfs(subSum+array[i]);
                    if(ret) {
                        return true;
                    }
                    check[i] = 0;
                }
            }
            return false;
        }

        private boolean isSame(int subSum) {
            return this.sum/2 == subSum;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        boolean ret = new Solution().solution(nums);
        if(ret) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }


    @Test
    public void test1() {
        //when
        boolean result3 = new Solution().solution(
                new int[]{1,22,10,11});
        //then
        Assert.assertTrue(result3);
        //when
        boolean result2 = new Solution().solution(
                new int[]{2,4,8});
        //then
        Assert.assertFalse(result2);
        //when
        boolean result = new Solution().solution(
                new int[]{1,3,5});
        //then
        Assert.assertFalse(result);
        //when
        boolean result1 = new Solution().solution(
                new int[]{1,3,5,6,7,10});
        //then
        Assert.assertTrue(result1);
    }
}