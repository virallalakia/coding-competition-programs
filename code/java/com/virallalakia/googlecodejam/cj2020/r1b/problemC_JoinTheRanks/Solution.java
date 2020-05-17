/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2020.r1b.problemC_JoinTheRanks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2020.
 * Competition: Google Code Jam 2020
 * Round: 1b
 * Problem: Problem A (Join The Ranks)
 * Result: Incomplete
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    for (int t = 0; t < _T_; t++) {
      evaluateCase(t + 1, SYS_IN.nextInt(), SYS_IN.nextInt());
    }
    SYS_IN.close();
  }

  private static void evaluateCase(final int t, final int _R_, final int _S_) {
    SYS_IN.nextLine();
    List<Integer> resultA = new ArrayList<>();
    List<Integer> resultB = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    try {
      for (int i = 0; i < _S_; i++) {
        for (int j = 0; j < _R_; j++) {
          list.add(j + 1);
        }
      }
      int index = -1;
      do {
        int count = 0;
        index = -1;
        for (int i = list.size() - 1; i >= 0; i--) {
          if (list.get(i) == _R_ && count == 0) {
            continue;
          } else if (list.get(i) == _R_ && count > 0) {
            index = i + 1;
            break;
          } else {
            count++;
          }
        }
        if (index >= 0) {
          resultA.add(index);
          resultB.add(count);
          List<Integer> l2 = new ArrayList<>();
          l2.addAll(list.subList(index, index + count));
          l2.addAll(list.subList(0, index));
          l2.addAll(list.subList(index + count, list.size()));
          list = l2;
        }
      } while (index != -1);
    } catch (Exception e) {
    }
    System.out.println(String.format("Case #%d: %d", t, resultA.size()));
    for (int i = 0; i < resultA.size(); i++) {
      System.out.println(String.format("%d %d", resultA.get(i), resultB.get(i)));
    }
  }

}
