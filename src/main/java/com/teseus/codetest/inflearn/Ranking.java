package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 직관적으로 풀다 이렇게 하는게 맞는가? 하는 생각이 들었다. 일단 임시 저장


public class Ranking {
    static class Solution {
        public int[] solution(int[] n) {
            int[] reversed = Arrays.stream(Arrays.copyOf(n, n.length)).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::valueOf).toArray();
            System.out.println("reversed = " + Arrays.toString(reversed));
            int[] ranks = new int[n.length];
            int count = 0;
            for (int i = 0; i < reversed.length; i++) {
                int index = find(n, reversed[i]);
                if(i == 0) {
                    count = i+1;
                } else if (reversed[i-1] != reversed[i]) {
                    count = i+1;
                }
                ranks[index] = count;
                System.out.print(count + ",");
            }
            return ranks;
        }

        private int find(int[] nums, int num) {
            for (int i = 0; i < nums.length; i++) {
                if(num == nums[i]){
                    return i;
                }
            }
            throw new IllegalArgumentException("");
        }
    }


    @Test
    public void test1(){
        //when
        int[] result1 = new Solution().solution(new int[]{10, 10, 20});
        //then
        Assert.assertArrayEquals(new int[]{1,1,3}, result1);
//        //when
//        int[] result = new Solution().solution(new int[]{87, 89, 92, 100, 76});
//        //then
//        Assert.assertArrayEquals(new int[]{4,3,2,1,5}, result);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] nums = new int[input1];
        int[] ranks = new Solution().solution(nums);
        System.out.println("ranks = " + Arrays.toString(ranks));
    }
}