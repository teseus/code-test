package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

// 처음은 생각 나는데로 작성했고,  동작은 제대로 했지만, 퍼포먼스가 낮아서 fail
// 에러가 나서 두번째로 공백문자들을 하나로 줄이는 코드를 넣어 보았다. 그러나 fail

public class JadenCase {
    class Solution {
        public String solution(String s) {
            s = s.replaceAll("\\s+", " ");
            String[] splits = s.split("\\s");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < splits.length; i++) {
                if(splits[i].matches("^[a-z].*")) {
                    sb.append((char) (splits[i].charAt(0) - 32));
                } else {
                    sb.append(splits[i].charAt(0));
                }
                sb.append(splits[i].substring(1).toLowerCase());
                if(i < splits.length-1){
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
    }

    @Test
    public void test1(){
        //when
        String result1 = new Solution().solution("for     thE lasT weeK");
        //then
        Assert.assertEquals("For The Last Week", result1);
        //when
        String result = new Solution().solution("3people unFollowed me");
        //then
        Assert.assertEquals("3people Unfollowed Me", result);
    }
}