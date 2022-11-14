package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Factorial {
    static class Solution {
        public int solution(int num) {
            return dfs(num);
        }

        private int dfs(int num) {
            if(num == 1){
                return 1;
            }
            int ret = dfs(num - 1);
            System.out.println(num + "*" + ret);
            return num * ret;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int count = new Solution().solution(len);
        System.out.println(count);
    }

    @Test
    public void test1(){
        //when
        int result = new Solution().solution(5);
        //then
        Assert.assertEquals(120, result);
    }
}