package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

// 생각 나는데로 풀어서 바로 맞추었으나 stream 을 쓰는 더 좋은 코드가 있음.
// 참고하여 더 개선을 하였음.
// stream groupby counting 기능으로 편하게 할 수 있음.

public class Camouflage {
    class Solution {
        public int solution(String[][] clothes) {
            return Arrays.stream(clothes)
                    .collect(groupingBy(p -> p[1],counting()))
                    .values()
                    .stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
        }
    }

    @Test
    public void test1(){
        //given
        Solution solution = new Solution();
        //when
        String[][] arg = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution.solution(arg);
        //then
        Assert.assertEquals(5, result);
        //when
        String[][] arg1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}};
        int result1 = solution.solution(arg1);
        //then
        Assert.assertEquals(3, result1);
        //when
        String[][] arg2 = {{"hat1", "hat"}, {"hat2", "hat"}, {"pants1", "pants"}, {"shirts1", "shirts"}};
        int result2 = solution.solution(arg2);
        //then
        Assert.assertEquals(11, result2);
    }
}