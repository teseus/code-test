package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

// 일단 내가 새운 알고리즘으로는 충족한다. 그런데 fail 났다.

//뒤가 A 이면 아닌것들만 더한다 -1 .  BAAA = 0  BBBAA = 3-1 = 2
//앞이 A 이면 아닌것 갯수만큼 더한다. AAAB = 1, AAABBB  = 3
//중간에 A 가 있다면 연속한 A 중에 가장 긴것이 전체 개수보다 같거나 크다면 전체 - 1 BBAAAC = 5
// BBAAAC = min(5, 3) back, BBBAAAC = min(6,5) back, BBBBAAAC = (7,7) back, forward,
// BBBBBAAAC = min(8,9) 8 forward A군 앞에것의 갯수가 A군보다 클때만 포워드 방향이다.

//BBBBAAAC = (7,7), BBBAAACB = (7,6), BBAAACBB = (7,5), BAAACBBB = (7,4)
//BBBBBAAAC = min(8,9), BBBBAAACB = min(8,8), BBBAAACBB = min(8,7)
//(앞-1)*2 + 뒷글


//ABBBBAAAAC 이런경우는 어떻게 되는가?
//AAAAAAAA 이면?


public class JoyStick {
    class Solution {
        int all = ('Z' - 'A') + 1;
        int mid = all /2;

        int startA = -1;
        int lenA = 0;

        public int solution(String name) {
            int distanceSum = 0;
            boolean continueA = false;
            for (int i = 0; i < name.length(); i++) {
                int dist = name.charAt(i) - 'A';
                if(dist <= mid) {
                    distanceSum += dist;
                } else {
                    distanceSum += (all-dist);
                }

                //처음 A
                if(!continueA && name.charAt(i) == 'A') {
                    startA = i;
                    lenA = 1;
                    continueA = true;
                }
                //A의 연결이 이어질때
                if(name.charAt(i) == 'A' && i>0 && name.charAt(i-1) == 'A') {
                    lenA = i - startA + 1;
                }
                //A의 연결이 끊어질때
                if(name.charAt(i) != 'A' && continueA) {
                    continueA = false;
                }
            }

            System.out.println("distanceSum = " + distanceSum);

            if(name.charAt(name.length()-1) == 'A') { //마지막이 A군
                if(startA == 0) {
                    return distanceSum;
                }
                return distanceSum + startA -1;
            } else if (startA == 0) { //처음이 A군
                return distanceSum + name.length() - lenA;
            } else if (lenA > 0) {
                int beforeALen = startA;
                if(beforeALen > (lenA + 1)) { //순방향
                    return distanceSum + (name.length()-1);
                } else { //역방향
                    int sum1 = (beforeALen - 1) * 2;
                    int sum2 = name.length() - (beforeALen + lenA);
                    return distanceSum + (sum1 + sum2);
                }
            }
            return distanceSum + (name.length()-1);
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