package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

//직관적으로 풀었고 바로 성공

public class Merge2Arrays {
    static class Solution {
        public int[] solution(int[] a, int[] b) {
            int len = a.length + b.length;
            int[] merge = new int[len];
            int ai = 0, bi = 0;
            for (int i = 0; i < len; i++) {
                if(ai < a.length && bi < b.length ) {
                    if(a[ai] <= b[bi]){
                        merge[i] = a[ai++];
                    } else {
                        merge[i] = b[bi++];
                    }
                }
                else if(ai < a.length) {
                    merge[i] = a[ai++];
                } else {
                    merge[i] = b[bi++];
                }
//                System.out.println(Arrays.toString(merge));
            }

            return merge;
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
        int result[] = new Solution().solution(new int[]{1, 3, 5}, new int[]{2, 3, 6, 7, 9});
        //then
        Assert.assertArrayEquals(new int[] {1, 2, 3, 3, 5, 6, 7, 9}, result);
    }
}