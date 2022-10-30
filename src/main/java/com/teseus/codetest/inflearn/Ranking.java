package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// 직관적으로 풀다 이렇게 하는게 맞는가? 하는 생각이 들었다. 일단 임시 저장
// 클래스를 만들어서 점수와, 인덱스를 넣는 방향으로 선회 해서 성공

public class Ranking {
    static class Solution {
        static class Rank {
            int point;
            int index;

            public Rank(int point, int index) {
                this.point = point;
                this.index = index;
            }
        }

        public int[] solution(int[] n) {
            List<Rank> ranks = new ArrayList<>();
            for (int i = 0; i < n.length; i++) {
                ranks.add(new Rank(n[i], i));
            }
            List<Rank> sorted = ranks.stream().sorted((a,b)->Integer.compare(b.point, a.point)).collect(Collectors.toList());
//            System.out.println("sorted = " + sorted);
            int[] ordered = new int[n.length];
            int count = 1;
            ordered[sorted.get(0).index] = count;
            for (int i = 1; i < sorted.size(); i++) {
                if(sorted.get(i-1).point != sorted.get(i).point) {
                    count = i+1;
                }
                ordered[sorted.get(i).index] = count;
            }
//            System.out.println("ordered = " + Arrays.toString(ordered));
            return ordered;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int length = in.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = in.nextInt();
        }
        int[] ranks = new Solution().solution(nums);
        for (int rank : ranks) {
            System.out.print(rank + " ");
        }
    }

    @Test
    public void test1(){
        //when
        int[] result1 = new Solution().solution(new int[]{5, 10, 10, 20});
        //then
        Assert.assertArrayEquals(new int[]{4,2,2,1}, result1);
        //when
        int[] result = new Solution().solution(new int[]{87, 89, 92, 100, 76});
        //then
        Assert.assertArrayEquals(new int[]{4,3,2,1,5}, result);
    }
}