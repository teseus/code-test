package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class LifeBoat {
    class Solution {
        int max = 0;
        public int solution(int[] people, int limit) {
            boolean[] checks = new boolean[people.length];
            dfs(checks, people, 0, 0, limit);
            return max;
        }

        private void dfs(boolean[] checks, int[] people, int weight, int time, int limit) {
            for (int i = 0; i < people.length; i++) {
                if(!checks[i] && limit >= weight + people[i]) {
                    checks[i] = true;
                    max = Math.max(max, time+1);
                    System.out.println("checks = " + Arrays.toString(checks) + ", people = " + Arrays.toString(people) + ", weight = " + (weight + people[i]) + ", time = " + time + 1 + ", limit = " + limit);
                    dfs(checks, people, weight + people[i] , time + 1, limit);
                    checks[i] = false;
                }
            }
        }
    }

    @Test
    public void test1(){
        //when
        int result = new Solution().solution(new int[]{70, 50, 80, 50}, 100);
        //then
        Assert.assertEquals(3, result);
    }
}