 package com.teseus.codetest.inflearn.seven;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 처음에 나는 루프를 먼저 돌면서 최종노드인지 체크하도록했으나, 모범 답안은 루프를 돌기전 최종 노드를 체크하고 아니면 루프를 돌도록 되어있어서 수정하였다.

 public class SearchPathList {
    static class Solution {
        private List<List<Integer>> graph;
        private int [] check;

        private int target;
        private int count = 0;
        private int answer = 0;

        public int solution(int nodeCount, int[][] matrix) {
            count = nodeCount;
            target = nodeCount;
            check = new int[nodeCount+1];
            graph = new ArrayList<>();
            for (int i = 0; i <= count; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] node : matrix) {
                graph.get(node[0]).add(node[1]);
            }

            graph.forEach(it -> System.out.println(Arrays.toString(it.toArray())));
            check[1] = 1;
            System.out.print("start: " + 1 + ", ");
            dfs(1);
            return this.answer;
        }

        private void dfs(int nodeNum) {
            if(nodeNum == target) {
                System.out.println("fount from :" + nodeNum + ",");
                answer++;
            } else {
                for (Integer one : graph.get(nodeNum)) {
                    if(check[one] == 0){
                        check[one] = 1;
                        System.out.print(" visitTo:" + one + ",");
                        dfs(one);
                        check[one] = 0;
                    }
                }
            }
        }
    }

    @Test
    public void test1(){
        //when
        int result = new Solution().solution(5,
                new int[][]{{1,2}, {1,3}, {1,4}, {2,1}, {2,3}, {2,5}, {3,4}, {4,2}, {4,5}});
        //then
        Assert.assertEquals(6, result);
    }
}