package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// 직관적으로 풀다 이렇게 하는게 맞는가? 하는 생각이 들었다. 일단 임시 저장
// 클래스를 만들어서 점수와, 인덱스를 넣는 방향으로 선회 해서 성공
// 정답을 보니 내 생각과는 완전히 다른 알고리즘으로 풀었다. 허탈했다. 결국은 아이디어의 싸움이라고 느껴진다.

public class Ranking {
    static class Solution {
        public int[] solution(int[] n) {
            int[] ordered = new int[n.length];
            for (int i = 0; i < n.length; i++) {
                int cnt = 1;
                for (int j = 0; j < n.length; j++) {
                    if(n[j]>n[i]) cnt++;
                }
                ordered[i] = cnt;
            }
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