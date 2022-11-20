package com.teseus.codetest.programmers.template;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
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
            return this.end - o.end;
        }
    }
    class Solution {
        public int solution(List<Time> arr, int num) {
            int cnt = 0;
            Collections.sort(arr);
            int endTime=0;
            for (Time time : arr) {
                if(time.start>=endTime) {
                    cnt++;
                    endTime = time.end;
                }
            }
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
        //given
        Solution solution1 = new Solution();
        //when
        List<Time> times1 = Arrays.asList(new Time(1, 4), new Time(2, 3), new Time(3, 5), new Time(4, 6), new Time(5, 7));
        int result1 = solution1.solution(times1, 5);
        Assert.assertEquals(3, result1);
    }
}