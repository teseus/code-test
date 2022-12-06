package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// dfs graph (포함, 안포함) 이진트리를 써서 직관적으로 해결했다.

public class BadugiHoping {
    static class Solution {
        int len = 0;
        int max = 0;

        int[] array;
        public int solution(int[] array, int max) {
            len = array.length;
            this.array = array;
            this.max = max;
            return dfs(array[0], 0);
        }

        private int dfs(int weight, int idx) {
            if( idx == len - 1 ) {
                return weight>max?0:weight;
            }
            int a = dfs(weight + array[idx+1], idx + 1);
            int b = dfs(weight, idx + 1);
            return Math.max(a,b);
        }

    }

    @Test
    public void test1() {
        //when
        int result = new Solution().solution(
                new int[]{81, 58, 42, 33, 61}, 259);
        //then
        Assert.assertEquals(242, result);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        int ret = new Solution().solution(nums, 259);
        System.out.println(ret);
    }

}