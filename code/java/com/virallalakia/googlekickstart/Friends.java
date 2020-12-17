/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * This is a solution for one of the problems for Google Kick Start. This is verified on Google Kick Start site.
 * Package definition needs to be removed and class name needs to be changed to 'Solution' before submission.
 * Competition: Google Kick Start 2020 - Round H
 * Problem: Problem D (Friends)
 */
public class Friends {

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
      int n = SYS_IN.nextInt();
      int q = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int[] names = getCodedNames(SYS_IN.nextLine().split(" "));
      List<Set<Integer>> friendships = new ArrayList<>(n);
      Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
      for (int ni = 0; ni < n; ni++) {
        friendships.add(new HashSet<>());
      }
      for (int ni = 0; ni < n; ni++) {
        Set<Integer> set = friendships.get(ni);
        for (int nii = ni + 1; nii < n; nii++) {
          if ((names[ni] & names[nii]) > 0) {
            set.add(nii);
            friendships.get(nii).add(ni);
          }
        }
      }
      names = null; // GC

      System.out.print("Case #" + t + ":");
      int x, y;
      for (int qi = 0; qi < q; qi++) {
        x = SYS_IN.nextInt() - 1;
        y = SYS_IN.nextInt() - 1;
        System.out.print(" " + getMinFriendshipChain(friendships, memo, Math.min(x, y), Math.max(x, y)));
        SYS_IN.nextLine();
      }
      System.out.println();

    } catch (Exception e) {
    }
  }

  private static int[] getCodedNames(final String[] names) {
    int[] codedNames = new int[names.length];
    char[] chars;
    for (int ni = 0; ni < names.length; ni++) {
      chars = names[ni].toCharArray();
      for (char ch : chars) {
        codedNames[ni] |= (1 << (ch - 'A'));
      }
    }
    return codedNames;
  }

  private static int getMinFriendshipChain(
      List<Set<Integer>> friendships,
      final Map<Integer, Map<Integer, Integer>> memo,
      final int x,
      final int y) {
    if (friendships.get(x).contains(y)) {
      return 2;
    }
    Map<Integer, Integer> mapX = memo.get(x);
    if (mapX != null) {
      Integer ans = mapX.get(y);
      if (ans != null) {
        return ans;
      }
    }
    int n = friendships.size();
    boolean[] visited = new boolean[n];
    int[] prev = new int[n]; // index base 1
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(x);
    visited[x] = true;
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      for (Integer next : friendships.get(cur)) {
        if (!visited[next]) {
          visited[next] = true;
          queue.offer(next);
          prev[next] = cur + 1;
        }
        if (next == y) {
          queue.clear();
        }
      }
    }
    if (prev[y] == 0) {
      if (mapX == null) {
        memo.put(x, new HashMap<>());
        mapX = memo.get(x);
      }
      mapX.put(y, -1);
    } else {
      List<Integer> path = new LinkedList<>();
      path.add(y);
      int prevN = y;
      while (prev[prevN] != 0 || prevN != x) {
        path.add(0, prev[prevN] - 1);
        prevN = prev[prevN] - 1;
      }
      path = new ArrayList<>(path);
      int xx, yy;
      for (int pi = 0; pi < path.size(); pi++) {
        xx = path.get(pi);
        mapX = memo.computeIfAbsent(path.get(pi), k -> new HashMap<>());
        for (int pii = pi + 1; pii < path.size(); pii++) {
          yy = path.get(pii);
          mapX.put(yy, yy - xx + 1);
        }
      }
    }
    return memo.get(x).get(y);
  }
}
