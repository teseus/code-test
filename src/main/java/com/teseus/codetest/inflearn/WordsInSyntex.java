package com.teseus.codetest.inflearn;

import java.util.Scanner;

// 인프런 강의 별로임. 일단 가장 쉬운문제 맛보기로 풀어봄

public class WordsInSyntex {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String maxWord = "";
        while(in.hasNext()){
            String word = in.next();
            if(word.equals("\n")) return;
            if(maxWord.length() < word.length()) {
                maxWord = word;
            }
        }

        System.out.println(maxWord);
        return ;
    }
}