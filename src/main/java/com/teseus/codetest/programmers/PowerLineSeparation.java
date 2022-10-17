package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PowerLineSeparation {
    class Solution {
        public int solution(int n, int[][] wires) {
            if(n==0) {
                return 0;
            }
            if(n==1) {
                return wires[0][0] + wires[0][1];
            }
            List<Integer>[] edges;
            int minDiffer = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < wires.length; i++) {
                edges = clearEdges(n);
                putEdges(edges, wires, i, i);
                int sum1 = trace(0, edges);
                edges = clearEdges(n);
                putEdges(edges, wires, i, wires.length);
                int sum2 = trace(i, edges);
                if(minDiffer < Math.abs(sum1-sum2)){
                    minDiffer = Math.abs(sum1-sum2);
                    minIdx = i;
                }
            }
            return minIdx;
        }

        private int trace(int start, List<Integer>[] nodes) {
            Stack<Integer> stack = new Stack<>();
            stack.push(start);
            boolean[] checks = new boolean[nodes.length];
            Arrays.fill(checks, false);
            int ans = 0;
            while(!stack.empty()){
                Integer pop = stack.pop();
                ans += pop;
                checks[pop] = true;
                for (int i = 0; i < nodes[pop].size(); i++) {
                    Integer sub = nodes[pop].get(i);
                    if(!checks[sub]) {
                        stack.push(sub);
                    }
                }
                System.out.println("pop = " + pop);
            }
            return ans;
        }

        private void putEdges(List<Integer>[] nodes, int[][] wires, int s, int e) {
            for (int i = s; i < e; i++) {
                nodes[wires[i][0]].add(wires[i][1]);
                nodes[wires[i][1]].add(wires[i][0]);
            }
        }

        private List<Integer>[] clearEdges(int num) {
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