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
 * This is a solution for Love Triangle problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class LoveTriangle {

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
      int[] nums = new int[n];
      for (int ni = 0; ni < n; ni++) {
        nums[ni] = SYS_IN.nextInt() - 1;
      }
      SYS_IN.nextLine();

      boolean[] visited = new boolean[n];
      boolean[] checked = new boolean[n];
      boolean ans = false;
      int c = 0;
      for (int ni = 0; ni < n && c < n && !ans; ni++) {
        if (visited[ni]) {
          continue;
        }
        visited[ni] = true;
        c++;
        int tmp = nums[ni];
        while (true) {
          if (visited[tmp]) {
            if (!checked[nums[tmp]]) {
              int tc = 1;
              int tmp2 = nums[tmp];
              checked[tmp] = true;
              while (tmp2 != tmp && tc <= 3) {
                checked[tmp2] = true;
                tc++;
                tmp2 = nums[tmp2];
              }
              if (tc == 3) {
                ans = true;
              }
            }
            break;
          }
          visited[tmp] = true;
          c++;
          tmp = nums[tmp];
        }
      }

      System.out.println(ans ? "YES" : "NO");
    } catch (Exception e) {}
  }

}
