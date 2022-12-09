package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// 인데스를 잘못 계산해서 고생했으나, 결과적으로 성공.
// 인덱스의 첫값과 끝값을 시뮬레이션을 꼭 해봐야 겠다.

public class MaximumPoint {
    static class Solution {
        int len = 0;
        int max = 0;

        int[] points;

        int[] times;

        int limitTime;

        public int solution(int[] points, int[] times, int limitTime) {
            len = points.length;
            this.points = points;
            this.times = times;
            this.limitTime = limitTime;
            dfs(0, 0, 0);
            return this.max;
        }

        private void dfs(int pointSum, int timeSum, int idx) {
//            System.out.println("pointSum = " + pointSum + ", timeSum = " + timeSum + ", idx = " + idx);
            if (timeSum > limitTime) {
//                System.out.println("return ========");
                return;
            }
            if( idx == len ) {
                max = Math.max(pointSum, max);
//                System.out.println("max =========: " + max);
                return;
            }
            dfs(pointSum + points[idx], timeSum + times[idx], idx + 1);
            dfs(pointSum, timeSum, idx + 1);
        }

    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int limit = in.nextInt();
        int[] points = new int[len];
        int[] times = new int[len];
        for (int i = 0; i < len; i++) {
            points[i] = in.nextInt();
            times[i] = in.nextInt();
        }
        int ret = new Solution().solution(points, times, limit);
        System.out.println(ret);
    }

    @Test
    public void test1() {
        //when
        int result = new Solution().solution(
                new int[]{10, 25, 15 , 6, 7}, new int[]{5, 12, 8, 3, 4}, 20);
        //then
        Assert.assertEquals(41, result);
    }

}