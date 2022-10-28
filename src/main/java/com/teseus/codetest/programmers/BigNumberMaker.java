package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

// 탐욕법
// 직관적으로 풀었으나 테스트 케이스 통과 제출했을때, 런타임에러...  왜 에러가 나오는 지 알 수가 없다.

public class BigNumberMaker {
    class Solution {
        private int max = 0;
        public String solution(String number, int k) {
            dfs(number, 0, "", 0, number.length() - k);
            return max+"";
        }

        private void dfs(String numbers, int curIdx, String combi, int depth, int limit) {
            if(depth == limit) {
                int num = Integer.parseInt(combi);
                if(num > max) {
                    max = num;
                }
                return ;
            }
            for (int i = curIdx; i < numbers.length(); i++) {
                    dfs(numbers, i+1, combi + numbers.charAt(i), depth+1, limit);
            }
        }
    }

    @Test
    public void test1(){
        //when
        String result7 = new Solution().solution("123", 1);
        //then
        Assert.assertEquals("23", result7);
        //when
        String result6 = new Solution().solution("987654321", 8);
        //then
        Assert.assertEquals("9", result6);
        //when
        String result5 = new Solution().solution("21", 1);
        //then
        Assert.assertEquals("2", result5);
        //when
        String result4 = new Solution().solution("4177252841", 1);
        //then
        Assert.assertEquals("477252841", result4);
        //when
        String result3 = new Solution().solution("4177252841", 4);
        //then
        Assert.assertEquals("775841", result3);
        //when
        String result2 = new Solution().solution("1231234", 3);
        //then
        Assert.assertEquals("3234", result2);
        //when
        String result = new Solution().solution("1924", 2);
        //then
        Assert.assertEquals("94", result);
    }
}