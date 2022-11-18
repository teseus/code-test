package com.teseus.codetest.inflearn;

import org.junit.Test;

// 설명을 듣고 풀었다. 하는 방식을 외어야 겠다.

public class GetPartDFS {
    static class Solution {
        private int l = 0;
        private boolean[] checks;
        public void solution(int n) {
            l = n;
            checks = new boolean[n+1];
            dfs(1);
        }

        private void dfs(int n) {
            if(n == l+1) {
                for (int i = 1; i <= l; i++) {
                    if(checks[i]) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println("");
            } else {
                checks[n] = true;
                dfs(n+1);
                checks[n] = false;
                dfs(n+1);
            }
        }
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        solution.solution(3);

        System.out.println("========");

        Solution solution1 = new Solution();
        solution1.solution(4);
    }
}