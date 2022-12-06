package com.teseus.codetest.inflearn.eight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// dfs graph (포함, 안포함) 이진트리를 써서 직관적으로 해결했다.
// 에러가났다. 처음 것을 무조건 포함하는 로직으로 만들었다. 그래서 배열을 n+1 로 잡고,0번째 배열에 0을 넣고 진행시켜서 성공했다.

public class BadugiHoping {
    static class Solution {
        int len = 0;
        int max = 0;

        int[] array;
        public int solution(int[] array, int max) {
            len = array.length;
            this.array = array;
            this.max = max;
            return dfs(array[0], 0);
        }

        private int dfs(int weight, int idx) {
            if( idx == len - 1 ) {
                return weight>max?0:weight;
            }
            int a = dfs(weight + array[idx+1], idx + 1);
            int b = dfs(weight, idx + 1);
            return Math.max(a,b);
        }

    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int weight = in.nextInt();
        int len = in.nextInt();
        int[] nums = new int[len+1];
        for (int i = 1; i <= len; i++) {
            nums[i] = in.nextInt();
        }
        int ret = new Solution().solution(nums, weight);
        System.out.println(ret);
    }

    @Test
    public void test1() {
        //when
        int result1 = new Solution().solution(
                new int[]{0, 2757, 5674, 9996, 2346, 4673, 5673, 1236, 4734, 754, 4534, 3563, 1}, 10000);
        //then
        Assert.assertEquals(9997, result1);
        //when
        int result = new Solution().solution(
                new int[]{81, 58, 42, 33, 61}, 259);
        //then
        Assert.assertEquals(242, result);
    }

}