package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// 1차로 그냥 직관적으로 풀었다. 결과는 success
// 2차는 풀이를 봤더니 string reverse 로 한게 아니라, 숫자를 뒤집는 알고리즘을 써서 한 것을 보고 거기에 맞춰서 다시 한번 풀었다.

public class ReversedPrimeNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int nums[] = new int[input1];
        for (int i = 0; i < input1; i++) {
            nums[i] = in.nextInt();
        }
        new Solution().solution(nums);
    }
    static class Solution {
        public void solution(int[] contents) {
            for (int num : contents) {
                int reversed = reverse(num);
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

        public int reverse(int num) {
            int temp = num; //1
            int reversed = 0;
            while(temp > 0) { //1
                reversed *= 10;
                reversed += temp % 10;
                temp = temp / 10; //0
            }
            return reversed;
        }
    }

    @Test
    public void test1(){
        //when
        new Solution().solution(new int[]{32,55,62,20,250,370,200,30,100});
    }

    @Test
    public void testReverse(){
        //when
        int result4 = new Solution().reverse(1230);
        //then
        Assert.assertEquals(321, result4);
        //when
        int result3 = new Solution().reverse(123);
        //then
        Assert.assertEquals(321, result3);
        //when
        int result2 = new Solution().reverse(230);
        //then
        Assert.assertEquals(32, result2);
        //when
        int result = new Solution().reverse(123);
        //then
        Assert.assertEquals(321, result);
    }
}