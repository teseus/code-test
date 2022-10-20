package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

public class JoyStick {
    class Solution {
        int all = ('Z' - 'A') + 1;
        int mid = all /2;

        boolean lastA = false;
        int contA = 0;

        public int solution(String name) {
            int distanceSum = 0;
            for (int i = 0; i < name.length(); i++) {
                int dist = name.charAt(i) - 'A';
                if(dist <= mid) {
                    distanceSum += dist;
                } else {
                    distanceSum += (all-dist);
                }


                if(name.charAt(i) == 'A') {
                    if(lastA) {

                    }
                    lastA = true;
                }
            }
            //뒤가 A 이면 아닌것들만 더한다 -1 .  BAAA = 0  BBBAA = 3-1 = 2
            //앞이 A 이면 아닌것 갯수만큼 더한다. AAAB = 1, AAABBB  = 3
            //중간에 A 가 있다면 연속한 A 중에 가장 긴것이 전체 개수보다 같거나 크다면 전체 - 1 BBAAAC = 5
            return distanceSum + (name.length()-1);
        }
    }

//중간에 A ㄱ


//012345 6789 짝수
//10/2 = 5
//5-0 <= 5
//6-0 > 5 -> 10-6 = 4

//01234 5678 홀수
//9/2 = 4
//4-0 <= 4
//5-0 > 4 -> 9-5 = 4

//A가 사이사이 섞인 경우는?
//    A로 끝나는 경우? - 마지막에서 A를 다 뺀다.
//    A로 시작하는 경우
//    중간에 A 인경우는 뒤에 있는 A 의 갯수와 같거나 작으면 돌아간다.

    @Test
    public void test1(){
        //when
        int result3 = new Solution().solution("JAAAAAAAN");
        //then
        Assert.assertEquals(23, result3);
        //when
        int result2 = new Solution().solution("JAAAAAAAN");
        //then
        Assert.assertEquals(23, result2);
        //when
        int result1 = new Solution().solution("JAAAAAAAN");
        //then
        Assert.assertEquals(23, result1);
        //when
        int result = new Solution().solution("JEROEN");
        //then
        Assert.assertEquals(56, result);
    }
}