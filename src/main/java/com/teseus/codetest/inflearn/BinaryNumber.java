package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// 직관적으로 바로 풀어서 성공
// 나는 num < 0 이면 sb 에 넣고 리턴하는 것으로 했었음.
// 답을 보니, num==0 일때까지 내려가서 리턴하게 되어 있어서 바꾸어 봤음.

public class BinaryNumber {
    static class Solution {
        public String solution(int num) {
            StringBuilder sb = new StringBuilder();
            dfs(sb, num);
            return sb.toString();
        }

        private void dfs(StringBuilder sb, int num) {
//            System.out.println("num = " + num);
            if(num==0) {
                return;
            }
            dfs(sb,num/2);
            sb.append(num % 2);
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        String result = new Solution().solution(len);
        System.out.println(result);
    }

    @Test
    public void test1(){
        //when
        String result3 = new Solution().solution(1024);
        //then
        Assert.assertEquals(Integer.toBinaryString(1024), result3);
        System.out.println(result3);
        //when
        String result2 = new Solution().solution(10);
        //then
        Assert.assertEquals(Integer.toBinaryString(10), result2);
        System.out.println(result2);
        //when
        String result1 = new Solution().solution(2);
        //then
        Assert.assertEquals(Integer.toBinaryString(2), result1);
        System.out.println(result1);
        //when
        String result = new Solution().solution(1);
        //then
        Assert.assertEquals(Integer.toBinaryString(1), result);
        System.out.println(result);
    }
}