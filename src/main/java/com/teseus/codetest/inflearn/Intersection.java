package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 처음 생각 나는 데로 했으나, 시간 초과 에러 발생

public class Intersection {
    static class Solution {
        public int[] solution(int[] arr1, int[] arr2) {
            List<Integer> inter = new ArrayList<>();
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    if(arr1[i] ==  arr2[j]) {
                        inter.add(arr1[i]);
                    }
                }
            }
            return inter.stream().sorted(Integer::compareTo).mapToInt(Integer::intValue).toArray();
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

        int[] ans = new Solution().solution(nums1, nums2);
        for (int an : ans) {
            System.out.print(an+" ");
        }
    }


    @Test
    public void test1(){
        //when
        int[] result = new Solution().solution(new int[] {1, 3, 9, 5, 2}, new int[] {3, 2, 5, 7, 8});
        //then
        Assert.assertArrayEquals(new int[] {2, 3, 5}, result);
    }
}