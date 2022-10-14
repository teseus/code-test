package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PowerLineSeparation {
    class Solution {
        public int solution(int n, int[][] wires) {
            List<Integer>[] nodes = getNodes(n);
            putEdges(nodes, wires);
            int ret = trace(nodes);
            int answer = -1;
            return answer;
        }

        private int trace(List<Integer>[] nodes) {
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            while(!stack.empty()){
                Integer pop = stack.pop();
                for (int i = 0; i < nodes[pop].size(); i++) {
                    stack.push(nodes[pop].get(i));
                }
                System.out.println("pop = " + pop);
            }
            return 0;
        }

        private void putEdges(List<Integer>[] nodes, int[][] wires) {
            for (int i = 0; i < wires.length; i++) {
                nodes[wires[i][0]].add(wires[i][1]);
            }
        }

        private List<Integer>[] getNodes(int num) {
            List<Integer>[] nodes = new List[num+1];
            for (int i = 1; i <= num; i++) {
                nodes[i] = new ArrayList<>();
            }
            return nodes;
        }
    }

    @Test
    public void test1(){
        //given
        Solution solution = new Solution();
        //when
        int[][] arg = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int result = solution.solution(9, arg);
        //then
        Assert.assertEquals(3, result);
    }
}