package com.github.cwdtom.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/dota2-senate/description/
 *
 * @author chenweidong
 */
public class Dota2Senate649 {
    class Solution {
        public String predictPartyVictory(String senate) {
            Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
            int n = senate.length();
            for (int i = 0; i < n; i++) {
                if (senate.charAt(i) == 'R') q1.add(i);
                else q2.add(i);
            }
            while (!q1.isEmpty() && !q2.isEmpty()) {
                int rIndex = q1.poll(), dIndex = q2.poll();
                if (rIndex < dIndex) {
                    q1.add(rIndex + n);
                } else {
                    q2.add(dIndex + n);
                }
            }
            return (q1.size() > q2.size()) ? "Radiant" : "Dire";
        }
    }
}
