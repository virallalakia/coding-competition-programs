package com.virallalakia.googlecodejam.cj2019.r1c.problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author virallalakia
 */
public class Solution {

    private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final String RESPONSE_Y = "Y";
    private static final String RESPONSE_N = "N";
    private static final String RESPONSE_A = "A";
    private static final String RESPONSE_B = "B";
    private static final String RESPONSE_C = "C";
    private static final String RESPONSE_D = "D";
    private static final String RESPONSE_E = "E";

    public static void main(String[] args) {
        int _T_ = SYS_IN.nextInt();
        int _F_ = SYS_IN.nextInt();
        for (int t = 1; t <= _T_; t++) {
            evaluateCase(t, _F_);
        }
        SYS_IN.close();
    }

    private static void evaluateCase(final int t, int _F_) {
        String result = "";
        List<Integer> allList;
        List<Integer> aList;
        List<Integer> bList;
        List<Integer> cList;
        List<Integer> dList;
        List<Integer> eList;
        // first place
        aList = new ArrayList<>(24);
        bList = new ArrayList<>(24);
        cList = new ArrayList<>(24);
        dList = new ArrayList<>(24);
        eList = new ArrayList<>(24);
        for (int i = 0; i < 119; i++) {
            System.out.println(i * 5 + 1);
            System.out.flush();
            switch (SYS_IN.next()) {
                case RESPONSE_Y:
                    return;
                case RESPONSE_A:
                    aList.add(i);
                    break;
                case RESPONSE_B:
                    bList.add(i);
                    break;
                case RESPONSE_C:
                    cList.add(i);
                    break;
                case RESPONSE_D:
                    dList.add(i);
                    break;
                case RESPONSE_E:
                    eList.add(i);
                    break;
                case RESPONSE_N:
                default:
                    SYS_IN.close();
                    System.exit(0);
            }
        }
        if (aList.size() == 23) {
            allList = aList;
            result += RESPONSE_A;
        } else if (bList.size() == 23) {
            allList = bList;
            result += RESPONSE_B;
        } else if (cList.size() == 23) {
            allList = cList;
            result += RESPONSE_C;
        } else if (dList.size() == 23) {
            allList = dList;
            result += RESPONSE_D;
        } else {
            allList = eList;
            result += RESPONSE_E;
        }
        // second place
        aList = new ArrayList<>(6);
        bList = new ArrayList<>(6);
        cList = new ArrayList<>(6);
        dList = new ArrayList<>(6);
        eList = new ArrayList<>(6);
        for (int i = 0; i < 23; i++) {
            System.out.println(allList.get(i) * 5 + 2);
            System.out.flush();
            switch (SYS_IN.next()) {
                case RESPONSE_Y:
                    return;
                case RESPONSE_A:
                    aList.add(i);
                    break;
                case RESPONSE_B:
                    bList.add(i);
                    break;
                case RESPONSE_C:
                    cList.add(i);
                    break;
                case RESPONSE_D:
                    dList.add(i);
                    break;
                case RESPONSE_E:
                    eList.add(i);
                    break;
                case RESPONSE_N:
                default:
                    SYS_IN.close();
                    System.exit(0);
            }
        }
        if (aList.size() == 5) {
            allList = aList;
            result += RESPONSE_A;
        } else if (bList.size() == 5) {
            allList = bList;
            result += RESPONSE_B;
        } else if (cList.size() == 5) {
            allList = cList;
            result += RESPONSE_C;
        } else if (dList.size() == 5) {
            allList = dList;
            result += RESPONSE_D;
        } else {
            allList = eList;
            result += RESPONSE_E;
        }
        // third place
        aList = new ArrayList<>(2);
        bList = new ArrayList<>(2);
        cList = new ArrayList<>(2);
        dList = new ArrayList<>(2);
        eList = new ArrayList<>(2);
        for (int i = 0; i < 5; i++) {
            System.out.println(allList.get(i) * 5 + 3);
            System.out.flush();
            switch (SYS_IN.next()) {
                case RESPONSE_Y:
                    return;
                case RESPONSE_A:
                    aList.add(i);
                    break;
                case RESPONSE_B:
                    bList.add(i);
                    break;
                case RESPONSE_C:
                    cList.add(i);
                    break;
                case RESPONSE_D:
                    dList.add(i);
                    break;
                case RESPONSE_E:
                    eList.add(i);
                    break;
                case RESPONSE_N:
                default:
                    SYS_IN.close();
                    System.exit(0);
            }
        }
        if (aList.size() == 1) {
            allList = aList;
            result += RESPONSE_A;
        } else if (bList.size() == 1) {
            allList = bList;
            result += RESPONSE_B;
        } else if (cList.size() == 1) {
            allList = cList;
            result += RESPONSE_C;
        } else if (dList.size() == 1) {
            allList = dList;
            result += RESPONSE_D;
        } else {
            allList = eList;
            result += RESPONSE_E;
        }
        // forth and fifth place
        for (int i = 5; i > 3; i--) {
            System.out.println(allList.get(0) * 5 + i);
            System.out.flush();
            switch (SYS_IN.next()) {
                case RESPONSE_Y:
                    return;
                case RESPONSE_A:
                    result += RESPONSE_A;
                    break;
                case RESPONSE_B:
                    result += RESPONSE_B;
                    break;
                case RESPONSE_C:
                    result += RESPONSE_C;
                    break;
                case RESPONSE_D:
                    result += RESPONSE_D;
                    break;
                case RESPONSE_E:
                    result += RESPONSE_E;
                    break;
                case RESPONSE_N:
                default:
                    SYS_IN.close();
                    System.exit(0);
            }
        }
        System.out.println(result);
        System.out.flush();
        switch (SYS_IN.next()) {
            case RESPONSE_Y:
                return;
            case RESPONSE_N:
            default:
                SYS_IN.close();
                System.exit(0);
        }
    }

}
