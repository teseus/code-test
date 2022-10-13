package com.teseus.codetest.leetcode;

import org.junit.Assert;
import org.junit.Test;

// 일단 생각한대로 진행했다. copy 갯수를 copy.length() > 2 으로 2이상이어야 하는데, 2초과로 실수
//             if(count*2 == s.length()) {
//                return s.length();
//            }
// 에서 return 을 빼먹어서 실수했다.

public class LongestPalindrome {
    class Solution {
        public int longestPalindrome(String s) {
            if(s.length() == 1) {
                return 1;
            }
            // check 배열 똑같이
            String copy = new String(s);
            int count = 0;
            // 2중 for
            for (int i = 0; i < s.length()-1 && copy.length() > 1; i++) {
                char c = s.charAt(i);
                int found = copy.indexOf(c);
                if (found >= 0) {
                    int found2 = copy.indexOf(c, found + 1);
                    if (found2 >= 0 && (copy.charAt(found) == copy.charAt(found2))) {
                        count++;
                        copy = copy.substring(0, found) +
                                copy.substring(found + 1, found2) +
                                copy.substring(found2 + 1);
                        System.out.println("restruct:" + copy);
                    }
                }
            }
            if(count*2 == s.length()) {
                return s.length();
            }
            return count*2+1;
        }
    }

    @Test
    public void test1(){
        //given
        Solution solution = new Solution();
        //when
        int result4 = solution.longestPalindrome("aa");
        //then
        Assert.assertEquals(2, result4);
        //when
        int result3 = solution.longestPalindrome("abcCBA");
        //then
        Assert.assertEquals(1, result3);
        //when
        int result2 = solution.longestPalindrome("a");
        //then
        Assert.assertEquals(1, result2);
        //when
        int result1 = solution.longestPalindrome("ABCD");
        //then
        Assert.assertEquals(1, result1);
        //when
        int result = solution.longestPalindrome("abccccdd");
        //then
        Assert.assertEquals(7, result);
    }
}