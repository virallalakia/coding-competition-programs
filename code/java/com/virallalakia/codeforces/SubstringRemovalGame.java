/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a solution for Substring Removal Game problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class SubstringRemovalGame {

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
      final char[] ip = (SYS_IN.nextLine() + "0").toCharArray();
      List<Integer> nums = new ArrayList();
      int lastZero = -1;
      for (int i = 0; i < ip.length; i++) {
        if (ip[i] == '0') {
          if (lastZero + 1 < i) {
            nums.add(i - lastZero - 1);
          }
          lastZero = i;
        }
      }
      Collections.sort(nums);

      int ans = 0;
      for (int ni = nums.size() - 1; ni >= 0; ni -= 2) {
        ans += nums.get(ni);
      }
      System.out.println(ans);
    } catch (Exception e) {}
  }
}
