/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * This is a solution for Death DBMS problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * This causes TLE!
 *
 * @author Viral Lalakia 
 */
public class DeathDBMS {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  static class Person implements Comparable<Person> {
    String name;
    int suspicion;
    int idx;

    public Person(String name, int suspicion, int idx) {
      this.name = name;
      this.suspicion = suspicion;
      this.idx = idx;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Person person = (Person) o;

      if (suspicion != person.suspicion) return false;
      if (idx != person.idx) return false;
      return name.equals(person.name);
    }

    @Override
    public int hashCode() {
      int result = name.hashCode();
      result = 31 * result + suspicion;
      result = 31 * result + idx;
      return result;
    }

    @Override
    public int compareTo(Person o) {
      if (this.suspicion == o.suspicion) {
        return this.name.length() - o.name.length();
      }
      return o.suspicion - this.suspicion;
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
      int m = SYS_IN.nextInt();
      SYS_IN.nextLine();
      Map<Integer, Person> map = new HashMap<>(n);
      Queue<Person> queue = new PriorityQueue<>(n);
      Queue<Person> tmp = new ArrayDeque<>();
      Person dummyPerson = new Person("", -1, -1);
      Person person;
      for (int ni = 1; ni <= n; ni++) {
        person = new Person(SYS_IN.nextLine().trim(), 0, ni);
        queue.offer(person);
        map.put(ni, person);
      }
      for (int mi = 0; mi < m; mi++) {
        if (SYS_IN.nextInt() == 1) {
          while (!tmp.isEmpty()) {
            queue.offer(tmp.poll());
          }
          person = map.get(SYS_IN.nextInt());
          queue.remove(person);
          person.suspicion = SYS_IN.nextInt();
          queue.offer(person);
          SYS_IN.nextLine();
        } else {
          String query = SYS_IN.nextLine().trim();
          int ans = tmp.stream().filter(p -> query.contains(p.name)).findFirst().orElse(dummyPerson).suspicion;
          if (ans == -1) {
            while (!queue.isEmpty()) {
              person = queue.poll();
              tmp.offer(person);
              if (query.contains(person.name)) {
                ans = person.suspicion;
                break;
              }
            }
          }
          System.out.println(ans);
        }
      }
    } catch (Exception e) {}
  }
}
