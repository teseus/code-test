package com.teseus.codetest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

// Priority Queue 를 사용하여 생각나는 대로 작성하였다.
// 단 역순으로 할때는  (a,b) -> b-a 를 썼는데 다른 사람이 한 코드를 보니, Collections.reverseOrder()를 써서 이저믕ㄴ 참고 하였다.


public class DoublePriorityQueue {
    class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> foward = new PriorityQueue<>();
            PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());
            for (String operation : operations) {
                String[] divided = operation.split(" ");
                processInQueue(divided[0], divided[1], foward, reverse);
            }

            if(foward.size() == 0){
                return new int[]{0,0};
            }

            return new int[]{reverse.poll(), foward.poll()};
        }

        private void processInQueue(String op, String data, PriorityQueue<Integer> queue, PriorityQueue<Integer> reverse) {
            switch (op) {
                case "I" :
                    queue.add(Integer.parseInt(data));
                    reverse.add(Integer.parseInt(data));
                    System.out.println("Add data:" + data);
                    break;
                case "D" :
                    if(queue.isEmpty()) {
                        break;
                    }
                    if(data.equals("-1")) {
                        System.out.println("Remove minimum data:" + reverse.remove(queue.poll()));
                    } else {
                        System.out.println("Remove maximum data:" + queue.remove(reverse.poll()));
                    }
                default:
                    break;
            }
        }
    }

    @Test
    public void test1(){
        //given
        Solution solution = new Solution();
        //when
        String [] arg = {"I 16", "I -5643"};
        int[] result = solution.solution(arg);
        //then
        Assert.assertArrayEquals(new int[]{16, -5643}, result);
        System.out.println("\n\n");
        //when
        String [] arg1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] result1 = solution.solution(arg1);
        //then
        Assert.assertArrayEquals(new int[]{0,0}, result1);
        System.out.println("\n\n");
        //when
        String [] arg2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] result2 = solution.solution(arg2);
        //then
        Assert.assertArrayEquals(new int[]{333,-45}, result2);
        System.out.println("\n\n");
    }
}
