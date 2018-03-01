package com.github.cwdtom.leetcode;

import java.util.LinkedList;
import java.util.List;

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
            char[] left = str.toCharArray();
            List<Node> list = new LinkedList<>();
            for (int i = 0; i < left.length && left[i] != '&';) {
                Node node = new Node(left[i] == '+');
                i++;
                StringBuilder sb = new StringBuilder();
                while (left[i] > 47 && left[i] < 58) {
                    sb.append(left[i]);
                    i++;
                }
                if ("".equals(sb.toString())) {
                    node.factor = 1;
                } else {
                    node.factor = Integer.parseInt(sb.toString());
                }
                if (left[i] == 'x') {
                    i++;
                    node.constant = false;
                } else {
                    node.constant = true;
                }
                list.add(node);
            }

            for (Node n : list) {
                if (n.constant) {
                    if (n.signal) {
                        factorNum += n.factor;
                    } else {
                        factorNum -= n.factor;
                    }
                } else {
                    if (n.signal) {
                        factorX += n.factor;
                    } else {
                        factorX -= n.factor;
                    }
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
        boolean signal;
        int factor;
        boolean constant;

        Node(boolean signal) {
            this.signal = signal;
        }
    }
}
