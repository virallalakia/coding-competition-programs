/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2021 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2021.r1a.problemA_AppendSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2021.
 * Round: 1A
 * Problem: Problem A (Append Sort)
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t) {
    int _N_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    int noOfAppendOp = 0;
    try {
      String preNumStr, curNumStr = Integer.toString(SYS_IN.nextInt());
      for (int i = 1; i < _N_; i++) {
        preNumStr = add1(curNumStr);
        curNumStr = Integer.toString(SYS_IN.nextInt());
        if (stringNumericalCompare(preNumStr, curNumStr) > 0) {
          if (preNumStr.startsWith(curNumStr)) {
            noOfAppendOp += (preNumStr.length() - curNumStr.length());
            curNumStr = preNumStr;
          } else {
            for (int j = 0; j < curNumStr.length(); j++) {
              if (curNumStr.charAt(j) > preNumStr.charAt(j)) {
                noOfAppendOp += (preNumStr.length() - curNumStr.length());
                curNumStr += "0".repeat(preNumStr.length() - curNumStr.length());
                break;
              } else if (curNumStr.charAt(j) < preNumStr.charAt(j)) {
                noOfAppendOp += (preNumStr.length() - curNumStr.length() + 1);
                curNumStr += "0".repeat(preNumStr.length() - curNumStr.length() + 1);
                break;
              }
            }
          }
        }
      }
      SYS_IN.nextLine();
    } catch (Exception ignored) {
    }
    return String.format("Case #%d: %d", t, noOfAppendOp);
  }

  private static int stringNumericalCompare(String num1, String num2) {
    int len = Integer.max(num1.length(), num2.length());
    if (len > num1.length()) {
      num1 = "0".repeat(len - num1.length()) + num1;
    }
    if (len > num2.length()) {
      num2 = "0".repeat(len - num2.length()) + num2;
    }
    return num1.compareTo(num2);
  }

  private static String add1(String num) {
    char[] chars = num.toCharArray();
    boolean carry = true;
    for (int i = chars.length - 1; i >= 0 && carry; i--) {
      carry = (chars[i] - '0' + 1) > 9;
      chars[i] = (char)(((chars[i] - '0' + 1) % 9) + '0');
    }
    String ans = new String(chars);
    if (carry) {
      ans = "1" + ans;
    }
    return ans;
  }
}
