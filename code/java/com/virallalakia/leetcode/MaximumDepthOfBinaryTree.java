/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

/**
 * This is a solution for Maximum Depth of Binary Tree problem of Leetcode.
 * This is verified on https://leetcode.com. Only marked code should be submitted.
 * 
 * @author Viral Lalakia 
 */
public class MaximumDepthOfBinaryTree {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // ======== submission start ========
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
  }
  // ======== submission end ========
}
