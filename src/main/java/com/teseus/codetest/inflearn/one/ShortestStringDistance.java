package com.teseus.codetest.inflearn.one;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// after learning

public class ShortestStringDistance {
    static class Solution {
        public String solution(String str, char ch) {
            StringBuilder sb = new StringBuilder();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ch) {
                    list.add(i);
                }
            }
            for (int i = 0; i < str.length(); i++) {
                int dis = Integer.MAX_VALUE;
                for (int j = 0; j < list.size(); j++) {
                    dis = Math.min(dis, Math.abs(list.get(j) - i));
                }
                sb.append(dis + " ");
            }
            return sb.toString().trim();
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        String result = new Solution().solution(input1, input2.charAt(0));
        System.out.println(result);
    }

    @Test
    public void test1(){
        //when
        String result1 = new Solution().solution("teachermode", 'e');
        //then
        Assert.assertEquals("1 0 1 2 1 0 1 2 2 1 0", result1);
    }
}