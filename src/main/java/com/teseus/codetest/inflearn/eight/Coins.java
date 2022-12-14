package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 처음에 생각은 BFS 로 하는 것이 맞을 것 같았으나, 답은 DFS 로 하는 것으로 나와 있고,
// 그러면 깊이가 너무 깊어지는 문제에 대해서는 최적화 방법이 따로 있어서. 그걸 적용해 보았다.

public class Coins {
    static class Solution {
        int answer = Integer.MAX_VALUE;
        int want = 0;
        Integer[] array;
        public int solution(Integer[] array, int want) {
            this.want = want;
            this.array = array;
            dfs(0, 0);
            return this.answer;
        }

        private void dfs(int level, int sum) {
            if(level > answer) {
                return;
            }
            if(want == sum) {
                answer = Math.min(answer, level);
            } else {
                for (int i = 0; i < array.length; i++) {
                    dfs(level + 1, sum + array[i]);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        Integer[] nums = new Integer[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums, Collections.reverseOrder());
        int want = in.nextInt();
        int count = new Solution().solution(nums, want);
        System.out.println(count);
    }

    @Test
    public void test1(){
        //when
        int result = new Solution().solution(new Integer[]{1, 2, 5}, 15);
        //then
        Assert.assertEquals(3, result);
    }
}