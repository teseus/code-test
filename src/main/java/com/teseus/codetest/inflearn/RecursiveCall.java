package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//일단 직관적으로 풀었다.

public class RecursiveCall {
    static class Solution {
        public List<Integer> solution(int n) {
            return dfs(new ArrayList<>(1), n);
        }

        private List<Integer> dfs(List<Integer> list, int end) {
            list.add(list.size()+1);
            if(list.size() != end){
                dfs(list, end);
            }
            return list;
        }

    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        List<Integer> results = new Solution().solution(len);
        results.stream().forEach(it-> System.out.print(it + " "));
    }

    @Test
    public void test1(){
        //when
        List<Integer> result = new Solution().solution(6);
        //then
        Assert.assertEquals(Arrays.asList(1,2,3,4,5,6), result);
    }
}