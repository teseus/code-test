package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//일단 깊이탐색으로 모든 경우의 수를 다 구해서 min 값으로 했다. 그러나 시간 초과로 실패
//다른 사람의 풀이를 보니 내가 문제를 잘못이해했다. 전체 탐색으로 오인했다.
//일단 문제는 2사람씩 탈경우를 말하는 것이었다.
//따라서 소팅을 하고, 맨뒤와 맨앞을 짝지워 태워 보낼 수 있는 지를 체크해서 짝으로 탄갯수를 전체 갯수에서 빼면 되는 방법이었다.
//아이디어의 싸움이다.
public class LifeBoat {
        class Solution {
            public int solution(int[] people, int limit) {
                Arrays.sort(people);
                int i = 0, j = people.length - 1;
                for (; i < j; --j) {
                    if (people[i] + people[j] <= limit)
                        ++i;
                }
                return people.length - i;
            }
        }

    @Test
    public void test1(){
        //when
        int result3 = new Solution().solution(new int[]{1,2,3,4,5,5,6,7,8,9}, 10);
        //then
        Assert.assertEquals(5, result3);
        //when
        int result2 = new Solution().solution(new int[]{40,40}, 40);
        //then
        Assert.assertEquals(2, result2);
        //when
        int result1 = new Solution().solution(new int[]{70, 80, 50}, 100);
        //then
        Assert.assertEquals(3, result1);
        //when
        int result = new Solution().solution(new int[]{70, 50, 80, 50}, 100);
        //then
        Assert.assertEquals(3, result);
    }
}