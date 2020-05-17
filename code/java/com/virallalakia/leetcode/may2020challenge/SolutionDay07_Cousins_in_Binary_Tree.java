/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.may2020challenge;

/*
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 7 (Cousins in Binary Tree)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay07_Cousins_in_Binary_Tree {
  public boolean isCousins(TreeNode r, int x, int y) {
    if (r == null || x == 0 || y == 0) {
      return false;
    }
    TreeNode[] p = new TreeNode[1];
    TreeNode xn, yn;
    int dx, dy;
    dx = findNode(r, x, 0, p);
    xn = p[0];
    if (dx < 1) {
      return false;
    }
    dy = findNode(r, y, 0, p);
    yn = p[0];
    return (dx == dy && xn != yn);
  }

  private int findNode(TreeNode n, int x, int cd, TreeNode[] p) {
    if ((n.left != null && n.left.val == x) || (n.right != null && n.right.val == x)) {
      p[0] = n;
      return cd;
    }
    int R = -1;
    if (n.left != null) {
      R = findNode(n.left, x, cd + 1, p);
    }
    if (R == -1 && n.right != null) {
      R = findNode(n.right, x, cd + 1, p);
    }
    return R;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

