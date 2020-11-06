/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This is a solution for The Delivery Dilemma problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * This gives Wrong Answer.
 * 
 * @author Viral Lalakia 
 */
public class TheDeliveryDilemma {

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
      int[] a = new int[n];
      for (int ni = 0; ni < n; ni++) {
        a[ni] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();
      int delivery = 0;
      int pickup = 0;
      int tmp;
      for (int ni = 0; ni < n; ni++) {
        tmp = SYS_IN.nextInt();
        if (Math.max(pickup, Math.max(a[ni], delivery)) <= Math.max(delivery, pickup + tmp)) {
          delivery = Math.max(a[ni], delivery);
        } else {
          pickup += tmp;
        }
      }
      SYS_IN.nextLine();
      System.out.println(Math.max(delivery, pickup));
    } catch (Exception e) {}
  }
}
