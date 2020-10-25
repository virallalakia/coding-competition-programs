/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This is a solution for A New Technique problem of Codeforces. This is verified on
 * https://codeforces.com. Package definition needs to be removed before submission.
 * Time complexity is O(n * m) which is the minimum required for the least I/O.
 * This causes TLE, not sure why!!
 *
 * @author Viral Lalakia
 */
public class ANewTechnique {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /** Main method for solution. Calls to evaluate one or more test cases. */
  public static void main(String[] args) {
    final int t = SYS_IN.nextInt(); // total test cases
    SYS_IN.nextLine();
    for (int ti = 0; ti < t; ti++) {
      evaluateCase();
    }
    SYS_IN.close();
  }

  /** Evaluate a test case. Handles I/O. */
  private static void evaluateCase() {
    try {
      int n = SYS_IN.nextInt();
      int m = SYS_IN.nextInt();
      SYS_IN.nextLine();
      String[] numsStr = new String[n];
      int[] col1 = new int[n];
      Map<Integer, Integer> rowIndexMap = new HashMap<>(n);
      boolean foundCol1 = false;
      int tmp;
      for (int ni = 0; ni < n; ni++) {
        tmp = SYS_IN.nextInt();
        numsStr[ni] = tmp + SYS_IN.nextLine();
        rowIndexMap.put(tmp, ni);
      }
      for (int mi = 0; mi < m; mi++) {
        if (!foundCol1) {
          col1[0] = SYS_IN.nextInt();
          if (rowIndexMap.containsKey(col1[0])) {
            foundCol1 = true;
            for (int ni = 1; ni < n; ni++) {
              col1[ni] = SYS_IN.nextInt();
            }
          }
        }
        SYS_IN.nextLine();
      }

      int rowIndex;
      for (int ni = 0; ni < n; ni++) {
        rowIndex = rowIndexMap.get(col1[ni]);
        System.out.println(numsStr[rowIndex]);
      }
    } catch (Exception e) {
    }
  }
}
