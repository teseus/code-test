package com.teseus.codetest.leetcode;

import com.teseus.codetest.leetcode.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

//root 가 널일경우 null 을 리턴함으로 안에서 left, right null 을 체크할 필요가 없다.

public class InvertBinaryTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            invertTree(root.left);
            invertTree(root.right);
            swap(root);
            return root;
        }

        private void swap(TreeNode root) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    @Test
    public void test1(){
        //given
        Solution solution = new Solution();
        //when
        TreeNode tree1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        TreeNode result1 = solution.invertTree(tree1);
        Assert.assertEquals(new TreeNode(2).val, result1.val);

        //when
        TreeNode a = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode b = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        TreeNode tree = new TreeNode(4, a, b);

        TreeNode result = solution.invertTree(tree);
        //then
        Assert.assertEquals(new TreeNode(4).val, result.val);
    }
}