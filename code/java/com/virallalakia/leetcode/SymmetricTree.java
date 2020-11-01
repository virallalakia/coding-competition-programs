/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a solution for Symmetric Tree problem of Leetcode.
 * This is verified on https://leetcode.com. Only marked code should be submitted.
 * 
 * @author Viral Lalakia 
 */
public class SymmetricTree {
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
  public boolean isSymmetric(TreeNode root) {
    List<Integer> inOrderList = inOrder(root, 0);
    int i = 0;
    int j = inOrderList.size() - 2;
    while (i < j) {
      if (inOrderList.get(i) != inOrderList.get(j) || inOrderList.get(i + 1) != inOrderList.get(j + 1)) {
        return false;
      }
      i += 2;
      j -= 2;
    }
    return true;
  }

  private List<Integer> inOrder(TreeNode n, int height) {
    List<Integer> ans = new ArrayList<>();
    if (n == null) {
      ans.add(height);
      ans.add(null);
    } else {
      ans.addAll(inOrder(n.left, height + 1));
      ans.add(height);
      ans.add(n.val);
      ans.addAll(inOrder(n.right, height + 1));
    }
    return ans;
  }
  // ======== submission end ========
}
