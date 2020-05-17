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
 * Problem: Problem 14 (Implement Trie (Prefix Tree))
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay14_Implement_Trie_OR_Prefix_Tree {
}

class Trie {

  Node root;

  /**
   * Initialize your data structure here.
   */
  public Trie() {
    root = new Node();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    if (word == null || (word = word.trim()).equals("")) {
      return;
    }
    Node n = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (n.children[c - 'a'] == null) {
        n.children[c - 'a'] = new Node();
      }
      n = n.children[c - 'a'];
    }
    n.val = word;
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    return search(word, false);
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    return search(prefix, true);
  }

  private boolean search(String word, boolean halfWord) {
    if (word == null || (word = word.trim()).equals("")) {
      return false;
    }
    Node n = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (n.children[c - 'a'] == null) {
        return false;
      }
      n = n.children[c - 'a'];
    }
    return (halfWord || word.equals(n.val));
  }

  class Node {
    String val = "";
    Node[] children = new Node[26];
  }

}
