package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

// 처음은 생각 나는데로 작성했고,  동작은 제대로 했지만, 퍼포먼스가 낮아서 fail
// 에러가 나서 두번째로 공백문자들을 하나로 줄이는 코드를 넣어 보았다. 그러나 fail
// 다른 사람의 답을 보았다. 모든 문자를 나누고, 처음 시작과 " " 스페이스가 있다면 다음은 대문자로 변경해서 처리했다.
// 결과적으로 같을 텐데, 왜 내가 한 것은 에러가 났을까?

public class JadenCase {
    class Solution {
        public String solution(String s) {
            System.out.println(s);
            String answer = "";
            String[] sp = s.toLowerCase().split("");
            boolean flag = true;

            for(String ss : sp) {
                answer += flag ? ss.toUpperCase() : ss;
                flag = ss.equals(" ") ? true : false;
            }

            return answer;
        }
    }

    @Test
    public void test1(){
        //when
        String result1 = new Solution().solution("for thE lasT weeK");
        //then
        Assert.assertEquals("For The Last Week", result1);
        //when
        String result = new Solution().solution("3people unFollowed me");
        //then
        Assert.assertEquals("3people Unfollowed Me", result);
    }
}