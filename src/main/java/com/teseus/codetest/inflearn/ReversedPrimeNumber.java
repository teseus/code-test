package com.teseus.codetest.inflearn;

import org.junit.Test;

import java.util.Scanner;

// 1차로 그냥 직관적으로 풀었다. 결과는 success

public class ReversedPrimeNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        String nums[] = new String[input1];
        for (int i = 0; i < input1; i++) {
            nums[i] = in.nextInt() + "";
        }
        new Solution().solution(nums);
    }
    static class Solution {
        public void solution(String[] contents) {
            for (String str : contents) {
                int reversed = Integer.parseInt(new StringBuilder(str).reverse().toString());
                if(isPrime(reversed)) {
                    System.out.print(reversed + " ");
                }
            }
        }

        private boolean isPrime(int reversed) {
            if(reversed<2) {
                return false;
            }
            for (int i = 2; i < reversed; i++) {
                if(reversed%i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void test1(){
        //when
        new Solution().solution(new String[]{"32","55","62","20","250","370","200","30","100"});
    }
}