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
 * This is a solution for Gennady and a Card Game problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class GennadyAndACardGame {

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
      String card = SYS_IN.nextLine();
      String[] cardsInHand = SYS_IN.nextLine().split(" ");

      String ans = "NO";
      for (String cardInHand : cardsInHand) {
        if (card.charAt(0) == cardInHand.charAt(0) || card.charAt(1) == cardInHand.charAt(1)) {
          ans = "YES";
          break;
        }
      }
      System.out.println(ans);
    } catch (Exception e) {}
  }
}
