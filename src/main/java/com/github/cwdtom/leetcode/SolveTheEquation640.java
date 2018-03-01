package com.github.cwdtom.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/solve-the-equation/description/
 *
 * @author chenweidong
 */
public class SolveTheEquation640 {
    public static void main(String[] args) {
        System.out.println(new SolveTheEquation640.Solution().solveEquation("x+5-3+x=6+x-2"));
    }

    static class Solution {
        public String solveEquation(String equation) {
            String[] s = equation.split("=");
            int factorX = 0, factorNum = 0;
            s[1] = s[1].replace("+", "&")
                    .replace("-", "+")
                    .replace("&", "-");
            if (s[1].charAt(0) != '-') {
                s[1] = "-" + s[1];
            }
            if (s[0].charAt(0) != '-') {
                s[0] = "+" + s[0];
            }
            String str = s[0] + s[1] + "&";
            char[] cs = str.toCharArray();
            List<Node> list = new LinkedList<>();
            for (int i = 0; i < cs.length && cs[i] != '&';) {
                Node node = new Node();
                StringBuilder sb = new StringBuilder();
                sb.append(cs[i]);
                i++;
                while (cs[i] > 47 && cs[i] < 58) {
                    sb.append(cs[i]);
                    i++;
                }
                if (sb.length() == 1) {
                    node.factor = Integer.parseInt(sb.append("1").toString());
                } else {
                    node.factor = Integer.parseInt(sb.toString());
                }
                if (cs[i] == 'x') {
                    i++;
                    node.constant = false;
                } else {
                    node.constant = true;
                }
                list.add(node);
            }

            for (Node n : list) {
                if (n.constant) {
                    factorNum += n.factor;
                } else {
                    factorX += n.factor;
                }
            }


            if (factorX == 0 && factorNum == 0) {
                return "Infinite solutions";
            } else if (factorX == 0) {
                return "No solution";
            }
            return "x=" + (0 - factorNum) / factorX;
        }
    }

    static class Node {
        int factor;
        boolean constant;
    }
}
