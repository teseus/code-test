package com.teseus.codetest.inflearn.eight;

import org.junit.Test;

import java.util.Scanner;

// 1차로 풀었음.

public class Permutation {
    static class Solution {
        int len = 0;
        Integer[] array;
        int[] nums;
        int[] check;
        public void solution(Integer[] array, int len) {
            this.len = len;
            this.nums = new int[len];
            this.array = array;
            this.check = new int[array.length];
            dfs(0);
        }

        private void dfs(int level) {
            if(level == len) {
                for (int i = 0; i < len; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println();
            } else {
                for (int i = 0; i < array.length; i++) {
                    if(check[i] == 0) {
                        check[i] = 1;
                        nums[level] = array[i];
                        dfs(level + 1);
                        check[i] = 0;
                    }
                }
            }
        }
    }

    @Test
    public void test1(){
        //when
        new Solution().solution(new Integer[]{3 ,6 ,9}, 2);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int want = in.nextInt();
        Integer[] nums = new Integer[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        new Solution().solution(nums, want);
    }
}