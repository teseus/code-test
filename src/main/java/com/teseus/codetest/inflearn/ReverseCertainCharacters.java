package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class ReverseCertainCharacters {
    static class Solution {
        public String solution(String str) {
            boolean[] map = new boolean[str.length()];
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(isAlphabet(ch)){
                    map[i] = true;
                    buf.append(ch);
                }
            }
            StringBuilder rev = buf.reverse();
//            System.out.println("rev = " + rev);
            int order = 0;
            StringBuilder newBuf = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if(map[i]) {
                    newBuf.append(rev.charAt(order++));
                } else {
                    newBuf.append(str.charAt(i));
                }
//                System.out.println(newBuf);
            }
            return newBuf.toString();
        }

        private static boolean isAlphabet(char ch) {
            return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String result = new Solution().solution(in.next());
        System.out.println(result);
    }

    @Test
    public void test1(){
        //when
        String result3 = new Solution().solution("123");
        //then
        Assert.assertEquals("123", result3);
        //when
        String result2 = new Solution().solution("a");
        //then
        Assert.assertEquals("a", result2);
        //when
        String result1 = new Solution().solution("aB");
        //then
        Assert.assertEquals("Ba", result1);
        //when
        String result = new Solution().solution("a#b!GE*T@S");
        //then
        Assert.assertEquals("S#T!EG*b@a", result);
    }
}