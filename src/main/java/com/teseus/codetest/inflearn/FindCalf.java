package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 이론을 듣고 직접 구현하여 성공

public class FindCalf {
    static class Solution {
        private int lookingFor;

        int bfs(int root) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> checks = new HashSet<>();
            queue.offer(root);
            checks.add(root);
            int level = 0;
            while(!queue.isEmpty()) {
                int len = queue.size();
                System.out.print(level + ": ");
                for (int i = 0; i < len; i++) {
                    int val = queue.poll();
                    if(val == lookingFor) {
                        return level;
                    }
                    System.out.print(val + " ");
                    int one = val + 1;
                    if(!checks.contains(one)) {
                        queue.offer(one);
                        checks.add(one);
                    }
                    int two = val - 1;
                    if(!checks.contains(two)) {
                        queue.offer(two);
                        checks.add(two);
                    }
                    int three = val + 5;
                    if(!checks.contains(three)) {
                        queue.offer(three);
                        checks.add(three);
                    }
                }
                level++;
                System.out.println();
            }
            throw new IllegalStateException();
        }

        public int solution(int pos1, int pos2) {
            lookingFor = pos2;
            return bfs(pos1);
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