package com.teseus.codetest.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 일단 생각 나는데로 작성했다.
// 그런데, 다른 사람의 정답을 보니, stream 으로만 했음.

public class BestAlbum {
    class Solution {
        class Entity implements Comparable<Entity> {
            private String genre;
            private int genreSum;
            private int playSum;
            private int no;
            private int countNo = 0;

            public Entity(String genre, int genreSum, int playSum, int no) {
                this.genre = genre;
                this.genreSum = genreSum;
                this.playSum = playSum;
                this.no = no;
            }

            @Override
            public int compareTo(Entity other) {
                int genreOrder = other.genreSum - this.genreSum;
                if(genreOrder != 0) return genreOrder;
                int playSumOrder = other.playSum - this.playSum;
                if(playSumOrder != 0) return playSumOrder;
                return this.no - other.no;
            }
        }
        public int[] solution(String[] genres, int[] plays) {
            Map<String, Integer> genreMap = new HashMap<>();
            //쟝르를 맵에 넣고, 합산시킨다.
            buildMapAndSum(genres, plays, genreMap);
            //합산된 값으로 장르의 총합과, 플레이횟수, 번호의 구조를 만들고 저장한다.
            List<Entity> sorted = sortEntities(genres, plays, genreMap);
            //루프를 도면서 따라 내려가면서 갯수를 쉰다.
            System.out.println(sorted);
            //배열로 전환시킨다. 그리고 잘라낸다.

            return getAnswer(sorted);
        }

        private int[] getAnswer(List<Entity> sorted) {
            String curGenre = "";
            int genCount = 0;

            for (int i = 0; i < sorted.size(); i++) {
                if(!curGenre.equals(sorted.get(i).genre)) {
                    genCount = 0;
                    curGenre = sorted.get(i).genre;
                }
                sorted.get(i).countNo = genCount++;
                System.out.println("add no =" + sorted.get(i).no + " genCount " +  genCount);
            }
            return sorted.stream().filter(it->it.countNo < 2).mapToInt(it->it.no).toArray();
        }

        private List<Entity> sortEntities(String[] genres, int[] plays, Map<String, Integer> genreMap) {
            List<Entity> entities = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                entities.add(new Entity(genres[i], genreMap.get(genres[i]), plays[i], i));
            }
            //소트 한다.
            return entities.stream().sorted().collect(Collectors.toList());
        }

        private void buildMapAndSum(String[] genres, int[] plays, Map<String, Integer> genreMap) {
            for (int i = 0; i < genres.length; i++) {
                if(genreMap.containsKey(genres[i])){
                    genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
                } else {
                    genreMap.put(genres[i], plays[i]);
                }
            }
        }
    }

    @Test
    public void test1(){
        //given
        Solution solution = new Solution();
        //when
        int[] results5 = solution.solution(new String[]{"classic", "classic",  "classic", "pop", "pop"}, new int[] {1000, 1000, 1000, 100, 100});
        //then
        Assert.assertArrayEquals(new int[] {0, 1, 3, 4}, results5);
        System.out.println("\n\n");
        //when
        int[] results4 = solution.solution(new String[]{"classic", "classic", "pop"}, new int[] {1 , 1, 1000});
        //then
        Assert.assertArrayEquals(new int[] {2, 0, 1}, results4);
        System.out.println("\n\n");
        //when
        int[] results3 = solution.solution(new String[]{"classic", "pop"}, new int[] {1, 1000});
        //then
        Assert.assertArrayEquals(new int[] {1,0}, results3);
        System.out.println("\n\n");
        //when
        int[] results2 = solution.solution(new String[]{"pop"}, new int[] {1000});
        //then
        Assert.assertArrayEquals(new int[] {0}, results2);
        System.out.println("\n\n");
        //when
        int[] results = solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});
        //then
        Assert.assertArrayEquals(new int[] {4, 1, 3, 0}, results);
        System.out.println("\n\n");

        //when
        int[] results1 = solution.solution(new String[]{}, new int[] {});
        //then
        Assert.assertArrayEquals(new int[] {}, results1);
        System.out.println("\n\n");

    }
}