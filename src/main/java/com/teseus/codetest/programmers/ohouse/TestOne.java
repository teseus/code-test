package com.teseus.codetest.programmers.ohouse;

import org.junit.Assert;
import org.junit.Test;


public class TestOne {
        class Solution {
            class Room {
                int idx, until, count;

                public Room(int idx, int until, int count) {
                    this.idx = idx;
                    this.until = until;
                    this.count = count;
                }
            }

            public int solution(int n, int[][] meetings) {
                Room[] rooms = new Room[n];
                int earlyIdx = Integer.MAX_VALUE;
                int earlyTime = Integer.MAX_VALUE;
                int maxIdx = 0;
                int maxCount = 1;
                for (int i = 0; i < n && i < meetings.length; i++) {
                    rooms[i] = new Room(i, meetings[i][1], 1);
                    if(earlyTime > rooms[i].until) {
                        earlyIdx = i;
                        earlyTime = rooms[i].until;
                    }
                    System.out.println("meeting no:" + i + ", until:" + rooms[i].until + ", count:" + rooms[i].count);
                }

                System.out.println("earlyIdx= " + earlyIdx + ", earlyTime= " + earlyTime);

                for (int i = n; i < meetings.length; i++) {
                    rooms[earlyIdx].until += (meetings[i][1] - meetings[i][0]);
                    rooms[earlyIdx].count++;
                    System.out.println("input room no:" + earlyIdx + ", until:" + rooms[earlyIdx].until + ", count:" + rooms[earlyIdx].count);
                    earlyTime = Integer.MAX_VALUE;
                    maxCount = 0;
                    for (int j = 0; j < n; j++) {
                        if(earlyTime > rooms[j].until) {
                            earlyIdx = j;
                            earlyTime = rooms[j].until;
                            System.out.println("after earlyIdx= " + earlyIdx + ", until = " + rooms[earlyIdx].until);
                        }
                        if(maxCount<rooms[j].count) {
                            maxIdx = j;
                            maxCount = rooms[j].count;
                            System.out.println("after maxIdx= " + maxIdx + ", maxCount= " + maxCount);
                        }
                    }
                }

                return maxIdx;
            }
        }

    @Test
    public void test1(){
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