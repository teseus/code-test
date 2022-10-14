package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class Tiredness {
    class Solution {
        private boolean check[];
        private int ans = 0;

        public int solution(int k, int[][] dungeons) {
            check = new boolean[dungeons.length];
            System.out.println("============");
            dfs(k, dungeons, 0);
            System.out.println("============");

            return ans;
        }
        public void dfs(int tired, int[][] dungeons, int cnt){
            System.out.println(Arrays.toString(check));
            for(int i=0; i<dungeons.length; i++){
                if(!check[i] && dungeons[i][0]<=tired){
                    check[i] = true;
                    dfs(tired-dungeons[i][1], dungeons, cnt+1);
                    check[i] = false;
                }
            }
            ans = Math.max(ans, cnt);
        }
    }

    @Test
    public void test1(){
        //when
        int[][] arg2 = {{80,20},{60,20},{40,20}};
        int result2 = new Solution().solution(80, arg2);
        //then
        Assert.assertEquals(3, result2);

        //when
        int[][] arg1 = {{80,20},{60,40},{60,10},{50, 10}, {40,10}};
        int result1 = new Solution().solution(80, arg1);
        //then
        Assert.assertEquals(4, result1);

        //when
        int[][] arg = {{80,20},{50,40},{30,10}};
        int result = new Solution().solution(80, arg);
        //then
        Assert.assertEquals(3, result);
    }
}