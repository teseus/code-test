package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 생각 나는데로 풀어서 바로 맞추었으나 stream 을 쓰는 더 좋은 코드가 있음.

public class Camouflage {
    class Solution {
        class Cloth {
            private String Name;
            private String Type;

            public Cloth(String name, String type) {
                Name = name;
                Type = type;
            }
        }
        public int solution(String[][] clothes) {
            if(clothes.length == 0) {
                return 0;
            }
            // 타잎 그룹으로 만든다.
            Map<String, List<Cloth>> group =
                    Arrays.stream(clothes).map(it -> new Cloth(it[0], it[1])).collect(Collectors.groupingBy(it -> it.Type));

            if(group.size() == 1) {
                return clothes.length;
            }

            int i = 0;

            int[] typeNums = new int[group.size()];
            for (List<Cloth> value : group.values()) {
                typeNums[i++] = value.size() + 1;
            }

            int sum = 1;
            for (int j = 0; j < typeNums.length; j++) {
                sum *= typeNums[j];
            }

            return sum-1;
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