package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

// 이론을 듣고 직접 구현하여 성공
// 정답 처럼 step 을 배열로 바꾸고, check 를 set 이 아니라 배열로 변경, 문제의 조건은 1 <= x <= 10000 임으로.

public class FindCalf {
    static class Solution {
        int bfs(int root, int lookingFor) {
            Queue<Integer> queue = new LinkedList<>();
            int[] checks = new int[10001];
            queue.offer(root);
            checks[root] = 1;
            int[] steps = {1, -1, 5};
            int level = 0;
            while(!queue.isEmpty()) {
                int len = queue.size();
                System.out.print(level + ": ");
                for (int i = 0; i < len; i++) {
                    int val = queue.poll();
                    System.out.print(val + " ");
                    for (int j = 0; j < steps.length; j++) {
                        int one = val + steps[j];
                        if(one == lookingFor) {
                            return level+1;
                        }
                        if(one > 1 && one <= 10000 && checks[one] == 0 ) {
                            queue.offer(one);
                            checks[one] = 1;
                        }
                    }
                }
                level++;
                System.out.println();
            }
            throw new IllegalStateException();
        }

        public int solution(int start, int end) {
            return bfs(start, end);
        }
    }

    @Test
    public void test1(){
        //given:
        Solution solution = new Solution();
        //when:
        int result = solution.solution(5, 14);
        //then:
        Assert.assertEquals(3, result);
    }
}