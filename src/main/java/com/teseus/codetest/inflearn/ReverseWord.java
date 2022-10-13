package com.teseus.codetest.inflearn;

import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            String word = in.next();
            System.out.println(new StringBuilder(word).reverse());
        }
    }
}