package com.virallalakia.googlecodejam.cj2019.r1c.problem1;

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
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String R = "R";
    private static final String P = "P";
    private static final String S = "S";

    public static void main(String[] args) {
        int _T_ = SYS_IN.nextInt();
        SYS_IN.nextLine();
        for (int t = 0; t < _T_; t++) {
            System.out.println(evaluateCase(t + 1, SYS_IN.nextInt()));
        }
        SYS_IN.close();
    }

    private static String evaluateCase(final int t, int _N_) {
        SYS_IN.nextLine();
        List<String> algos = new ArrayList<>(_N_);
        for (int i = 0; i < _N_; i++) {
            algos.add(SYS_IN.nextLine());
        }
        StringBuilder resultAlgo = new StringBuilder();
        boolean r, p, s;
        for (int i = 0; i < 500 && _N_ > 0; i++) {
            r = p = s = true;
            List<String> rList = new ArrayList<>(_N_);
            List<String> pList = new ArrayList<>(_N_);
            List<String> sList = new ArrayList<>(_N_);
            for (int n = 0; n < _N_ && (r || p || s); n++) {
                String algo = algos.get(n);
                int index = i % algo.length();
                switch (algo.substring(index, index + 1)) {
                    case R:
                        rList.add(algo);
                        s = false;
                        break;
                    case P:
                        pList.add(algo);
                        r = false;
                        break;
                    case S:
                        sList.add(algo);
                        p = false;
                        break;
                    default:
                        r = p = s = false;
                        break;
                }
            }
            algos = new ArrayList<>(_N_);
            if (r && !p) {
                resultAlgo.append(R);
                algos.addAll(rList);
            } else if (p && !s) {
                resultAlgo.append(P);
                algos.addAll(pList);
            } else if (!r && s) {
                resultAlgo.append(S);
                algos.addAll(sList);
            } else {
                resultAlgo = new StringBuilder();
                resultAlgo.append(IMPOSSIBLE);
                break;
            }
            _N_ = algos.size();
        }
        return String.format("Case #%d: %s", t, resultAlgo.toString());
    }

}
