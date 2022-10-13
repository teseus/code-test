package com.teseus.codetest.leetcode;

import org.junit.Assert;
import org.junit.Test;

// 일단 생각한대로 진행했다. copy 갯수를 copy.length() > 2 으로 2이상이어야 하는데, 2초과로 실수
//             if(count*2 == s.length()) {
//                return s.length();
//            }
// 에서 return 을 빼먹어서 실수했다.

// solution 에서는 알파벳의 아스키 분포가 65~122 라 아예 128개의 int 배열을 버퍼로 생성하고
// 주어진 문자열 s.toCharArray() 로 아키키 코드값의 배열을 만든다음에 이 값을 버퍼의 인수로 삼아 ++ 증가 시킨다.
// 최종적으로 /2 *2 한후 버퍼를 전체 순회하면서 값을 모두 더하고 이때 이값이 짝수이면서 원래의 값이 홀수면 하나더하고 아니면 /2 *2 한 값을 리턴한다.

public class LongestPalindrome {
    class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[128];
            for (char c: s.toCharArray())
                count[c]++;

            int ans = 0;
            for (int v: count) {
                ans += v / 2 * 2;
                if (ans % 2 == 0 && v % 2 == 1)
                    ans++;
            }
            return ans;
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