package com.teseus.codetest.inflearn.one;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// after learning

public class StringCompression {
    static class Solution {
        public String solution(String str) {
            int count = 1;
            str += ' ';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length()-1; i++) {
                if(str.charAt(i) == str.charAt(i+1)) {
                    count++;
                } else {
                    sb.append(str.charAt(i));
                    if(count>1) sb.append(count);
                    count = 1;
                }
            }
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