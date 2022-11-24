package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

// 1차로 풀어본다 풀이는 보지 않았고 설명만 들어봤다

public class BFS {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class Solution {
        int bfs(Node node) {
            int level = 0;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            while(!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    Node poped = queue.poll();
                    if(poped.left == null && poped.right == null) {
                        return level;
                    }
                    if(poped.left!=null) queue.offer(poped.left);
                    if(poped.right!=null) queue.offer(poped.right);
                }
                level ++;
            }
            throw new IllegalArgumentException();
        }
    }

    @Test
    public void test1(){
        //given:
        Solution solution = new Solution();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        //when:
        int result = solution.bfs(root);
        //then:
        Assert.assertEquals(1, result);
        //give:
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        //when:
        int result1 = solution.bfs(root);
        //then:
        Assert.assertEquals(2, result1);
    }
}