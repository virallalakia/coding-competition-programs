/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * This is a solution for Boring Card Game problem of Codeforces.
 * This is not yet verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class BoringCardGame {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  static class Hand implements Comparable<Hand> {
    int a, b, c;
    int extraCards1, extraCards2;

    public Hand(int a, int b, int c) {
      this.a = Math.min(a, Math.min(b, c));
      this.c = Math.max(a, Math.max(b, c));
      this.b = a + b + c - this.a - this.c;
      this.extraCards1 = b - a - 1;
      this.extraCards2 = c - b - 1;
    }

    @Override
    public int compareTo(Hand o) {
      if (this.extraCards1 + this.extraCards2 == o.extraCards1 + o.extraCards2) {
        return this.a - o.a;
      }
      return this.extraCards1 + this.extraCards2 - o.extraCards1 - o.extraCards2;
    }
  }

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
      int n = SYS_IN.nextInt();
      SYS_IN.nextLine();
      Queue<Hand> p1QueueReady = new PriorityQueue<>(n);
      Queue<Hand> p1QueueNeedProcess = new PriorityQueue<>(n);
      boolean[] canBeDrawn = new boolean[6 * n + 1];
      boolean[] drawnCards = new boolean[6 * n + 1];
      int nextCardForP2 = 1;
      int a = 0, b = 0, c = 0;
      Hand hand;
      for (int ni = 0; ni < n; ni++) {
        a = SYS_IN.nextInt();
        b = SYS_IN.nextInt();
        c = SYS_IN.nextInt();
        canBeDrawn[a] = true;
        canBeDrawn[b] = true;
        canBeDrawn[c] = true;
        hand = new Hand(a, b, c);
        if (hand.c - hand.a == 2) {
          p1QueueReady.offer(hand);
        } else {
          p1QueueNeedProcess.offer(hand);
        }
      }
      SYS_IN.nextLine();
      for (int ni = 0; ni < n; ni++) {
        // player1
        hand = p1QueueReady.poll();
        drawnCards[hand.a] = true;
        drawnCards[hand.b] = true;
        drawnCards[hand.c] = true;
        System.out.printf("%d %d %d\n", hand.a, hand.b, hand.c);
        // player2
        hand = p1QueueNeedProcess.poll();
        if (hand == null) {
          nextCardForP2 = 1;
          while (drawnCards[nextCardForP2] || !canBeDrawn[nextCardForP2]) {
            nextCardForP2++;
          }
          a = nextCardForP2;
          drawnCards[a] = true;
          while (drawnCards[nextCardForP2] || !canBeDrawn[nextCardForP2]) {
            nextCardForP2++;
          }
          b = nextCardForP2;
          drawnCards[b] = true;
          while (drawnCards[nextCardForP2] || !canBeDrawn[nextCardForP2]) {
            nextCardForP2++;
          }
          c = nextCardForP2;
          drawnCards[c] = true;
        } else {
          int ti;
          if (hand.extraCards1 > 0) {
            ti = hand.a + 1;
            hand.extraCards1 -= 3;
          } else {
            ti = hand.b + 1;
            hand.extraCards2 -= 3;
          }
          if ((hand.extraCards1 + hand.extraCards2) == 0) {
            p1QueueReady.offer(hand);
          } else {
            p1QueueNeedProcess.offer(hand);
          }
          while (drawnCards[ti]) {
            ti++;
          }
          a = ti;
          drawnCards[a] = true;
          while (drawnCards[ti]) {
            ti++;
          }
          b = ti;
          drawnCards[b] = true;
          while (drawnCards[ti]) {
            ti++;
          }
          c = ti;
          drawnCards[c] = true;
        }
        System.out.printf("%d %d %d\n", a, b, c);
      }
    } catch (Exception e) {}
  }
}
