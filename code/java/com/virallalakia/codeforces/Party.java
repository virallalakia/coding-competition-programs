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
 * This is a solution for Party problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class Party {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /**
   * Main method for solution. Calls to evaluate one or more test cases.
   */
  public static void main(String[] args) {
    evaluateCase();
    SYS_IN.close();
  }

  /**
   * Evaluate a test case. Handles I/O.
   */
  private static void evaluateCase() {
    try {
      int n = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int[] parent = new int[n];
      for (int ni = 0; ni < n; ni++) {
        parent[ni] = SYS_IN.nextInt() - 1;
        if (parent[ni] == -2) {
          parent[ni] = ni;
        }
        SYS_IN.nextLine();
      }

      int ans = 0;
      for (int ni = 0; ni < n; ni++) {
        int i = ni;
        int c = 1;
        while (i != parent[i]) {
          i = parent[i];
          c++;
        }
        ans = Math.max(ans, c);
      }

      System.out.println(ans);
    } catch (Exception e) {}
  }

}
