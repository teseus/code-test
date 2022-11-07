package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 처음 생각 나는 데로 했으나, 시간 초과 에러 발생
// 두개의 배열을 먼저 소팅하고, 소팅한 결과들로 루프를 한번 돌게 하는 로직으로 변경해서 성공, 답을 참고 했다.

public class Intersection {
    static class Solution {
        public List<Integer> solution(int[] arr1, int[] arr2) {
            List<Integer> inter = new ArrayList<>();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int a=0, b=0;
            while (a<arr1.length && b<arr2.length) {
                if(arr1[a] == arr2[b]){
                    inter.add(arr1[a++]);
                    b++;
                } else if (arr1[a] < arr2[b]) {
                    a++;
                } else {
                    b++;
                }
            }
            return inter;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len1 = in.nextInt();
        int[] nums1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            nums1[i] = in.nextInt();
        }
        int len2 = in.nextInt();
        int[] nums2 = new int[len2];
        for (int i = 0; i < len2; i++) {
            nums2[i] = in.nextInt();
        }

        List<Integer> arns = new Solution().solution(nums1, nums2);
        for (int an : arns) {
            System.out.print(an+" ");
        }
    }


    @Test
    public void test1(){
        //when
        List<Integer> result = new Solution().solution(new int[] {1, 3, 9, 5, 2}, new int[] {3, 2, 5, 7, 8});
        //then
        Assert.assertEquals(Arrays.asList(2,3,5), result);
    }
}