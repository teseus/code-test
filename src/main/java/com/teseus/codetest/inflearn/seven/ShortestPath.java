 package com.teseus.codetest.inflearn.seven;

 import org.junit.Test;

 import java.util.*;

 public class ShortestPath {
    static class Solution {
        private List<List<Integer>> graph;

        private Queue<Integer> queue = new LinkedList<>();
        private int [] check;
        private int [] distances;

        public void solution(int nodeCount, int edgeCount, int[][] matrix) {
            distances = new int[nodeCount+1];
            check = new int[nodeCount+1];
            graph = new ArrayList<>();
            for (int i = 0; i <= nodeCount; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] node : matrix) {
                graph.get(node[0]).add(node[1]);
            }

            graph.forEach(it -> System.out.println(Arrays.toString(it.toArray())));
            check[1] = 1;
            distances[1] = 0;
            bfs(1);
            for (int i = 2; i <= nodeCount; i++) {
                System.out.println(i + " : " + distances[i]);
            }
        }

        private void bfs(int start) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            while(!queue.isEmpty()) {
                Integer node = queue.poll();
                for (Integer subNode : graph.get(node)) {
                    if(check[subNode] == 0) {
                        check[subNode] = 1;
                        queue.offer(subNode);
                        distances[subNode] = distances[node] + 1;
                    }
                }
            }
        }
    }

    @Test
    public void test1(){
        //when
        new Solution().solution(6, 9,
                new int[][]{{1,3}, {1,4}, {2,1}, {2,5}, {3,4}, {4,5}, {4,6}, {6,2}, {6,5}});
    }
}