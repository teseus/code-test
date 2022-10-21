package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

public class JoyStick {
    class Solution {
        int all = ('Z' - 'A') + 1;
        int mid = all /2;

        int lastA = -1;
        int lenA = 0;

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
                    if(lastA != -1) {
                        lastA = i;
                    }
                    lenA = ( i - lastA ) + 1;
                } else {
                    lastA = -1;
                }
            }

            if(name.charAt(name.length()-1) == 'A') { //마지막이 A군
                return distanceSum + lastA-1;
            } else if (lastA == 0) { //처음이 A군
                return distanceSum + name.length() - lenA;
            } else if (lenA > 0) {
                int notAlen = lastA;
                if(notAlen > lenA) {
                    return distanceSum + (name.length()-1);
                } else {
                    return distanceSum + notAlen;
                }
            }
            //BBABABAAAAAAC
            //뒤가 A 이면 아닌것들만 더한다 -1 .  BAAA = 0  BBBAA = 3-1 = 2
            //앞이 A 이면 아닌것 갯수만큼 더한다. AAAB = 1, AAABBB  = 3
            //중간에 A 가 있다면 연속한 A 중에 가장 긴것이 전체 개수보다 같거나 크다면 전체 - 1 BBAAAC = 5
            // BBAAAC = min(5, 3) back, BBBAAAC = min(6,5) back, BBBBAAAC = (7,7) back, forward,
            // BBBBBAAAC = min(8,9) 8 forward A군 앞에것의 갯수가 A군보다 클때만 포워드 방향이다.

            //ABBBBAAAAC 이런경우는 어떻게 되는가?
            //AAAAAAAA 이면?
            return distanceSum + (name.length()-1);
        }
    }

    @Test
    public void test1(){
        //when
        int result3 = new Solution().solution("BAAAAAAAC");
        //then
        Assert.assertEquals(4, result3);
//        //when
//        int result2 = new Solution().solution("JAAAAAAAN");
//        //then
//        Assert.assertEquals(23, result2);
//        //when
//        int result1 = new Solution().solution("JAAAAAAAN");
//        //then
//        Assert.assertEquals(23, result1);
//        //when
//        int result = new Solution().solution("JEROEN");
//        //then
//        Assert.assertEquals(56, result);
    }
}