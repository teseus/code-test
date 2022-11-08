package com.teseus.codetest.inflearn;

import java.util.Scanner;

//일단 직관적으로 풀었다.
//2차는 풀이를 보고 따라 짜보았다. 재귀함수를 통해 뒤집는방법이다. 일단 재귀 호출하고, 끝에 오면 리턴, 재귀 함수 호출에서 리턴되면 그때 출력의 구조이다.

public class RecursiveCall {
    static class Solution {
        public void solution(int n) {
            dfs(n);
        }

        private void dfs(int n) {
            if( n == 0 ) {
                return;
            }
            dfs(n-1);
            System.out.print(n + " ");
        }

    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        new Solution().solution(len);
    }
}