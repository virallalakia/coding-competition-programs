/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.year2020.may2020challenge;

/*
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 20 (Kth Smallest Element in a BST)
 * Result: Pass
 * Year: 2020
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SolutionDay20_Kth_Smallest_Element_in_a_BST {
  int c;
  public int kthSmallest(TreeNode root, int k) {
    c=k;
    return DFSTillKth(root);
  }

  private int DFSTillKth(TreeNode n) {
    if (n == null) {
      return -1;
    }
    if(c <= 0) {
      return n.val;
    }
    int R = DFSTillKth(n.left);
    if (R != -1) {
      return R;
    }
    if(--c <= 0) {
      return n.val;
    }
    return DFSTillKth(n.right);
  }
}
