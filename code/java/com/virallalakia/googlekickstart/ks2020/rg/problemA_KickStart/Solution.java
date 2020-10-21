/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.rg.problemA_KickStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: G
 * Problem: Problem A (Kick Start)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int t = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int ti = 0; ti < t; ti++) {
      evaluateCase(ti + 1);
    }
    SYS_IN.close();
  }

  private static void evaluateCase(final int t) {
    try {
      char[] s = SYS_IN.nextLine().toCharArray();
      int len = s.length;
      int ans = 0;
      int kickCount = 0;
      for (int li = 0; li < len - 4; li++) {
        switch (s[li]) {
          case 'K':
            if (s[li + 1] == 'I' && s[li + 2] == 'C' && s[li + 3] == 'K') {
              kickCount++;
              li += 2;
            }
            break;
          case 'S':
            if (s[li + 1] == 'T' && s[li + 2] == 'A' && s[li + 3] == 'R' && s[li + 4] == 'T') {
              ans += kickCount;
              li += 4;
            }
            break;
        }
      }

      System.out.printf("Case #%d: %d\n", t, ans);
    } catch (Exception e) {
    }
  }
}
