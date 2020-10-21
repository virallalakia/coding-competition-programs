/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.rg.problemC_CombinationLock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: G
 * Problem: Problem C (Combination Lock)
 * Year: 2020
 */
public class Solution_Original {

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
      int w = SYS_IN.nextInt();
      int n = SYS_IN.nextInt();
      SYS_IN.nextLine();
      long[] digits = new long[w];
      for (int wi = 0; wi < w; wi++) {
        digits[wi] = SYS_IN.nextInt() - 1;
      }
      SYS_IN.nextLine();

      Arrays.sort(digits);
      long ans = solveLockProblem(digits, n);

      if (n > 2) {
        int tmp = (n >> 1);
        boolean flag = false;
        for (int wi = 0; wi < w; wi++) {
          if (digits[wi] < tmp) {
            digits[wi] += n;
            flag = true;
          } else {
            break;
          }
        }
        if (flag) {
          Arrays.sort(digits);
          ans = Math.min(ans, solveLockProblem(digits, n));
        }

        if ((tmp << 1) != n) {
          tmp++;
          flag = false;
          for (int wi = 0; wi < w; wi++) {
            if (digits[wi] < tmp) {
              digits[wi] += n;
              flag = true;
            } else {
              break;
            }
          }
          if (flag) {
            Arrays.sort(digits);
            ans = Math.min(ans, solveLockProblem(digits, n));
          }
        }
      }

      System.out.printf("Case #%d: %d\n", t, ans);
    } catch (Exception e) {
    }
  }

  /**
   * Solves lock problem.
   * @param digits sorted digits of all wheels
   * @param n possible numbers in a wheel
   * @return minimum moves to make all wheels to show same number
   */
  private static long solveLockProblem(long[] digits, int n) {
    int len = digits.length;
    long[] ans = {Long.MAX_VALUE, Long.MAX_VALUE};
    long[] numsToCheck = new long[2 - (len % 2)];
    numsToCheck[0] = digits[len >> 1];
    if (len % 2 == 0) {
      numsToCheck[1] = digits[(len >> 1) + 1];
    }
    long tmp;
    for (int ni = 0; ni < numsToCheck.length; ni++) {
      ans[ni] = 0L;
      for (int di = 0; di < len; di++) {
        tmp = Math.abs(digits[di] - numsToCheck[ni]);
        ans[ni] += Math.min(tmp, n - tmp);
      }
    }
    return Math.min(ans[0], ans[1]);
  }
}
