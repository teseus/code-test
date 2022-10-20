package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//일단 깊이탐색으로 모든 경우의 수를 다 구해서 min 값으로 했다. 그러나 시간 초과로 실패
public class LifeBoat {
    class Solution {
        int min = Integer.MAX_VALUE;
        public int solution(int[] people, int limit) {
            boolean[] checks = new boolean[people.length];
            Arrays.fill(checks, false);
            dfs(checks, people, 0, 1, limit);
            return min;
        }

        private void dfs(boolean[] checks, int[] people, int weight, int time, int limit) {
            int current = 0;
            for (int i = 0; i < people.length; i++) {
                if(!checks[i]) {
                    checks[i] = true;
                    //무게가 안넘으면 무게만 증가 시키고 마크하고 재귀호출한다.
                    if(limit >= weight + people[i]) {
                        current = time;
//                        System.out.println("checks = " + Arrays.toString(checks) + ", people = " + Arrays.toString(people) + ", weight = " + (weight + people[i]) + ", current = " + current + ", limit = " + limit);
                        dfs(checks, people, weight + people[i], current, limit);
                    } else { //무게가 넘으면 새로운 배, 이 사람의 몸무게로 무게 세트
                        current = time + 1;
//                        System.out.println("checks = " + Arrays.toString(checks) + ", people = " + Arrays.toString(people) + ", weight = " + people[i] + ", current = " + current + ", limit = " + limit);
//                        System.out.println("초과 weight + people[i] = " + (weight + people[i]) + ", old = " + time + ", current = " + current);
                        dfs(checks, people, people[i], current, limit);
                    }
                    if(isAll(checks)) {
                        min = Math.min(current, min);
                        System.out.println("end : min = " + min + ", current = " + current);
                    }
                    checks[i] = false;
                }
            }
        }

        private boolean isAll(boolean[] checks) {
            int count=  0;
            for (boolean check : checks) {
                if(check) {
                    count++;
                }
            }
            return checks.length == count;
        }
    }

    @Test
    public void test1(){
        //when
        int result3 = new Solution().solution(new int[]{1,2,3,4,5,5,6,7,8,9}, 10);
        //then
        Assert.assertEquals(5, result3);
//        //when
//        int result2 = new Solution().solution(new int[]{40,40}, 40);
//        //then
//        Assert.assertEquals(2, result2);
//        //when
//        int result1 = new Solution().solution(new int[]{70, 80, 50}, 100);
//        //then
//        Assert.assertEquals(3, result1);
//        //when
//        int result = new Solution().solution(new int[]{70, 50, 80, 50}, 100);
//        //then
//        Assert.assertEquals(3, result);
    }
}