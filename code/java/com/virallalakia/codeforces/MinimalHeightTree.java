/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This is a solution for Minimal Height Tree problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class MinimalHeightTree {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /**
   * Main method for solution. Calls to evaluate one or more test cases.
   */
  public static void main(String[] args) {
    final int t = SYS_IN.nextInt(); // total test cases
    SYS_IN.nextLine();
    for (int ti = 0; ti < t; ti++) {
      evaluateCase();
    }
    SYS_IN.close();
  }

  /**
   * Evaluate a test case. Handles I/O.
   */
  private static void evaluateCase() {
    try {
      int n = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int treeMinHeight = 1;
      SYS_IN.nextInt(); // read root node (1)
      int prev = -1;
      int cur;
      int parentLayerNodes = 1;
      int curLayerNodes = 0;
      for (int ni = 1; ni < n; ni++) {
        cur = SYS_IN.nextInt();
        if (prev > cur) {
          parentLayerNodes--;
          if (parentLayerNodes == 0) {
            treeMinHeight++;
            parentLayerNodes = curLayerNodes;
            curLayerNodes = 0;
          }
        }
        curLayerNodes++;
        prev = cur;
      }
      System.out.println(treeMinHeight);
    } catch (Exception e) {}
  }
}
