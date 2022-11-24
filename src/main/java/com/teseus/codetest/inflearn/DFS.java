package com.teseus.codetest.inflearn;

import org.junit.Assert;
import org.junit.Test;

public class DFS {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class Solution {
        int dfs(int level, Node node) {
            if(node.left == null && node.right == null) {
                return level;
            } else {
                return Math.min(dfs(level + 1, node.left), dfs(level + 1, node.right));
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
        //when:
        int result = solution.dfs(0, root);
        //then:
        Assert.assertEquals(1, result);
        //give:
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        //when:
        int result1 = solution.dfs(0, root);
        //then:
        Assert.assertEquals(2, result1);

    }
}