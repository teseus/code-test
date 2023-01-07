package com.teseus.codetest.inflearn.one;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// without learning

public class StringCompression {
    static class Solution {
        public String solution(String str) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i-1) == str.charAt(i)) {
                    count++;
                } else {
                    if(count>1) sb.append(count);
                    sb.append(str.charAt(i));
                    count = 1;
                }
            }
            if(count>1) sb.append(count);
            return sb.toString();
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        String result = new Solution().solution(input1);
        System.out.println(result);
    }

    @Test
    public void test1(){
        //when
        String result1 = new Solution().solution("KSTTTSEEKFKKKDJJGG");
        //then
        Assert.assertEquals("KST3SE2KFK3DJ2G2", result1);
        //when
        String result = new Solution().solution("KKHSSSSSSSE");
        //then
        Assert.assertEquals("K2HS7E", result);
    }
}