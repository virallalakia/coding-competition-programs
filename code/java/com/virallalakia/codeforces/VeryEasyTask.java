/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is a solution for Very Easy Task problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class VeryEasyTask {

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
      int x = SYS_IN.nextInt();
      int y = SYS_IN.nextInt();
      SYS_IN.nextLine();

      List<Integer> pattern = new ArrayList(x + y);
      int xi = x;
      int yi = y;
      while (xi != yi) {
        if (xi < yi) {
          pattern.add(xi);
          xi += x;
        } else {
          pattern.add(yi);
          yi += y;
        }
      }
      pattern.add(xi);
      pattern.add(yi);

      long ans = (long) pattern.get(0);
      n--;
      int sz = pattern.size();
      int max = pattern.get(sz - 1);
      if (n >= sz) {
        ans += (long)max * (long)(n / sz);
        n %= sz;
      }
      if (n > 0) {
        ans += pattern.get(n - 1);
      }
      System.out.println(ans);
    } catch (Exception e) {}
  }
}
