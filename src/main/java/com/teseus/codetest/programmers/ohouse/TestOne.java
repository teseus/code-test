package com.teseus.codetest.programmers.ohouse;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class TestOne {
        class Solution {
            class Room implements Comparable<Room>{
                int idx, until, count;

                public Room(int idx, int until, int count) {
                    this.idx = idx;
                    this.until = until;
                    this.count = count;
                }

                @Override
                public int compareTo(Room o) {
                    if(this.until == o.until) {
                        return this.idx - o.idx;
                    }
                    return this.until - o.until;
                }
            }

            public int solution(int n, int[][] meetings) {
                PriorityQueue<Room> earlyRoom = new PriorityQueue<>();
                List<Room> list = new ArrayList<>();

                for (int i = 0; i < n && i < meetings.length; i++) {
                    Room r = new Room(i, meetings[i][1], 1);
                    earlyRoom.add(r);
                    list.add(r);
                }

                for (int i = n; i < meetings.length; i++) {
                    Room earliestRoom = earlyRoom.poll();
                    System.out.println("earliest room no:" + earliestRoom.idx + ", until:" + earliestRoom.until + ", count:" + earliestRoom.count);
                    earliestRoom.until += (meetings[i][1] - meetings[i][0]);
                    earliestRoom.count ++;
                    System.out.println("input room no:" + earliestRoom.idx + ", until:" + earliestRoom.until + ", count:" + earliestRoom.count);
                    earlyRoom.add(earliestRoom);
                }

                return list.stream().max(Comparator.comparing(it->it.count)).get().idx;
            }
        }

    @Test
    public void test1(){
        //when
        int result4 = new Solution().solution(100, new int[][]{{((5*10^5)-1),(5*10^5)}});
        //then
        Assert.assertEquals(0, result4);
        //when
        int result2 = new Solution().solution(1, new int[][]{{1,4}, {2,5}, {4,10}, {5,7}, {7,9}});
        //then
        Assert.assertEquals(0, result2);

        //when
        int result1 = new Solution().solution(2, new int[][]{{1,4}, {2,5}, {4,10}, {5,7}, {7,9}});
        //then
        Assert.assertEquals(1, result1);
        //when
        int result = new Solution().solution(3, new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}});
        //then
        Assert.assertEquals(1, result);
        //when
        int result3 = new Solution().solution(4, new int[][]{{0,10},{1,5},{2,7},{3,4}});
        //then
        Assert.assertEquals(0, result3);
    }
}