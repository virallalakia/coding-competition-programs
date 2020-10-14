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
 * This is a solution for Avoiding Zero problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class AvoidingZero {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /**
   * Main method for solution. Calls to evaluate one or more test cases.
   */
  public static void main(String[] args) {
    final int t = SYS_IN.nextInt(); // total test cases
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
      List<Integer> pos = new ArrayList<>(n);
      List<Integer> neg = new ArrayList<>(n);
      int posSum = 0;
      int negSum = 0;
      int zeroCount = 0;
      int tmp = 0;
      for (int ni = 0; ni < n; ni++) {
        tmp = SYS_IN.nextInt();
        if (tmp == 0) {
          zeroCount++;
        } else if (tmp > 0) {
          pos.add(tmp);
          posSum += tmp;
        } else {
          neg.add(tmp);
          negSum += tmp;
        }
      }
      SYS_IN.nextLine();

      if (posSum == -negSum) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
        if (posSum > -negSum) {
          pos.addAll(neg);
        } else {
          neg.addAll(pos);
          pos = neg;
        }
        System.out.printf("%d", pos.get(0));
        for (int i = 1; i < pos.size(); i++) {
          System.out.printf(" %d", pos.get(i));
        }
        for (int i = 0; i < zeroCount; i++) {
          System.out.printf(" %d", 0);
        }
        System.out.println();
      }
    } catch (Exception e) {}
  }
}
