package com.teseus.codetest.inflearn.eight;

import org.junit.Test;

import java.util.Scanner;

// 1차로 풀었음.

public class GetCombination {
    static class Solution {
        int[] combi;
        int limit;
        int end;
        public void solution(int num, int limit) {
            this.limit = limit;
            combi = new int[limit];
            end = num;
            combi(0, 1);
        }

        private void combi(int level, int num) {
            if(level == limit){
                for (int one : combi) {
                    System.out.print(one + " ");
                }
                System.out.println();
            } else {
                for (int i = num; i <= end; i++) {
                    combi[level] = i;
                    combi(level+1, i+1);
                }
            }
        }

    }

    @Test
    public void test1(){
        //when
        new Solution().solution(4, 2);
        //when
        new Solution().solution(5, 3);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        int sum = in.nextInt();
        new Solution().solution(num, sum);
    }
}