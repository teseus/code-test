package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 직관적으로 풀어서 성공, 그러나 해답은 다른 방식이 었다 dfs(n-2) + def(n-1) 이런식 이었고, 결과를 받아서 결과를 다시 순회하면서 찍도록 하였다.

public class Pibonacci {
    static class Solution {
        public List<Integer> solution(int num) {
            List<Integer> lists = new ArrayList<>();
            return dfsPibo(lists,num-1);
        }

        private List<Integer> dfsPibo(List<Integer> lists, int n) {
            if(n==1){
                lists.add(1);
                lists.add(1);
                System.out.print("1 1 ");
                return lists;
            }
            dfsPibo(lists, n-1);
            int a = lists.get(n-2);
            int b = lists.get(n-1);
            lists.add(a+b);
            System.out.print((a + b) + " ");
            return lists;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        List<Integer> count = new Solution().solution(len);
        System.out.println(count);
    }

    @Test
    public void test1(){
        //when
        List<Integer> result = new Solution().solution(7);
        //then
        Assert.assertEquals(Arrays.asList(1, 1, 2, 3, 5, 8, 13), result);
    }
}