package com.teseus.codetest.inflearn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class Solution {

        Node root;

        void bfs(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            int level = 0;
            while(!queue.isEmpty()) {
                int len = queue.size();
                System.out.print(level + ": ");
                for (int i = 0; i < len; i++) {
                    Node node = queue.poll();
                    System.out.print(node.data + " ");
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
                level++;
                System.out.println(" ");
            }
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
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        solution.bfs(root);
        //when
        //then
    }
}