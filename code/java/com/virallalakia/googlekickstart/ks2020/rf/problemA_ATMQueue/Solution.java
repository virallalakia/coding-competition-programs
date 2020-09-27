/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.rf.problemA_ATMQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: F
 * Problem: Problem A (ATM Queue)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  private static class Person implements Comparable<Person> {
    int v;
    int i;

    public Person(int v, int i) {
      this.v = v;
      this.i = i;
    }

    @Override
    public int compareTo(Person o) {
      return (this.v != o.v ? this.v - o.v : this.i - o.i);
    }
  }

  public static void main(String[] args) {
    int t = SYS_IN.nextInt();
    for (int ti = 0; ti < t; ti++) {
      evaluateCase(ti + 1);
    }
    SYS_IN.close();
  }

  private static void evaluateCase(final int t) {
    try {
      int n = SYS_IN.nextInt();
      double x = SYS_IN.nextInt();
      SYS_IN.nextLine();
      Queue<Person> queue = new PriorityQueue<>(n);
      for (int ni = 1; ni <= n; ni++) {
        queue.offer(new Person((int) Math.ceil(SYS_IN.nextInt() / x), ni));
      }
      SYS_IN.nextLine();

      System.out.printf("Case #%d:", t);
      while (!queue.isEmpty()) {
        System.out.printf(" %d", queue.poll().i);
      }
      System.out.println("");
    } catch (Exception e) {
    }
  }
}
