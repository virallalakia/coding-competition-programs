/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start. This is verified on Google Kick Start site.
 * Package definition needs to be removed and class name needs to be changed to 'Solution' before submission.
 * Competition: Google Kick Start 2020 - Round B
 * Problem: Problem C (Robot Path Decoding)
 */
public class RobotPathDecoding {

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
      final int limit = 1_000_000_000;
      String program = SYS_IN.nextLine();
      int len = program.length();
      long x = 0L;
      long y = 0L;
      Deque<Long> mul = new ArrayDeque<>();
      mul.push(1L);
      for (int ni = 0; ni < len; ni++) {
        switch (program.charAt(ni)) {
          case 'E':
            x = (x + mul.peek()) % limit;
            break;
          case 'W':
            x = (x - mul.peek()) % limit;
            break;
          case 'S':
            y = (y + mul.peek()) % limit;
            break;
          case 'N':
            y = (y - mul.peek()) % limit;
            break;
          case ')':
            mul.pop();
            break;
          default:
            mul.push((mul.peek() * Integer.parseInt(program.substring(ni, ni + 1))) % limit);
            ni++;
            break;
        }
      }

      System.out.println("Case #" + t + ": " + (((x + limit) % limit) + 1) + " " + (((y + limit) % limit) + 1));
    } catch (Exception e) {
    }
  }
}
