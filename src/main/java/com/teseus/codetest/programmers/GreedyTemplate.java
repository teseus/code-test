package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GreedyTemplate {
    class Time implements Comparable<Time> {
        public int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(o.end == this.end) {
                return this.start - o.end;
            }
            return this.end - this.start;
        }
    }
    class Solution {
        public int solution(List<Time> arr, int num) {
            int cnt = 0;
            return cnt;
        }
    }

    @Test
    public void test1(){
        //given
        Solution solution = new Solution();
        //when
        Arrays.asList(new Time(3,3),new Time(2,3),new Time(1,3));
        int result = solution.solution(Arrays.asList(new Time(3,3),new Time(2,3),new Time(1,3)), 3);
        Assert.assertEquals(2, result);
    }
}