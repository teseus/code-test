package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

// 일단 내가 새운 알고리즘으로는 충족한다. 그런데 fail 났다.
// 다른 사람의 답이다. 이해가 안간다. 내가 낸 test 를 통과도 못한다. 이거 뭐지


public class JoyStickOtherAnswer {
    class Solution {
        public int solution(String name) {
            int answer = 0;
            int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
            for(char c:name.toCharArray())
                answer+=diff[c-'A'];

            int length=name.length();
            int min=length-1;

            for(int i=0;i<length;i++){
                int next=i+1;
                while(next<length && name.charAt(next)=='A'){
                    next++;
                }
                min=Math.min(min,i+length-next+Math.min(i,length-next));
            }

            return answer+min;
        }
    }

    @Test
    public void test1(){
        //when
        int result15 = new Solution().solution("AAAAAAAA"); //2
        //then
        Assert.assertEquals(0, result15);
        //when
        int result14 = new Solution().solution("JAZ"); //2
        //then
        Assert.assertEquals(11, result14);

        //BBBBBAAAC = min(8,9), BBBBAAACB = min(8,8), BBBAAACBB = min(8,7)

        //when
        int result13 = new Solution().solution("ABBBBAAAAC"); //2
        //then
        Assert.assertEquals(15, result13);
        //when
        int result12 = new Solution().solution("BBBAAACBB"); //2
        //then
        Assert.assertEquals(14, result12);
        //when
        int result11 = new Solution().solution("BBBBAAACB"); //2
        //then
        Assert.assertEquals(15, result11);
        //when
        int result10 = new Solution().solution("BBBBBAAAC"); //2
        //then
        Assert.assertEquals(15, result10);
        //when
        int result9 = new Solution().solution("ABBBBB"); //2
        //then
        Assert.assertEquals(10, result9);
        //when
        int result8 = new Solution().solution("AB"); //2
        //then
        Assert.assertEquals(2, result8);
        //when
        int result7 = new Solution().solution("A"); //2
        //then
        Assert.assertEquals(0, result7);
        //when
        int result6 = new Solution().solution("B"); //2
        //then
        Assert.assertEquals(1, result6);
        //when
        int result5 = new Solution().solution("BBBA"); //2
        //then
        Assert.assertEquals(5, result5);
        //when
        int result4 = new Solution().solution("BA"); //0
        //then
        Assert.assertEquals(1, result4);
        //when
        int result3 = new Solution().solution("BAAAAAAAC");
        //then
        Assert.assertEquals(4, result3);
        //when
        int result2 = new Solution().solution("JAAAAAAAN");
        //then
        Assert.assertEquals(23, result2);
        //when
        int result = new Solution().solution("JEROEN");
        //then
        Assert.assertEquals(56, result);
    }
}