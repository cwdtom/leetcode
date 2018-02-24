package com.github.cwdtom.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/description/
 * 广度优先搜索
 *
 * @author chenweidong
 */
public class WordLadder127 {
    public static void main(String[] args) {
        List<String> wordList = new LinkedList<>(Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"));
        System.out.println(
                new Solution().ladderLength("hot", "dog", wordList)
        );
    }

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int step = 0;
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            while (!queue.isEmpty()) {
                step += 1;
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    String tmp = queue.poll();
                    if (tmp.equals(endWord)) {
                        return step;
                    }
                    for (int j = 0; j < wordList.size(); j++) {
                        if (compare(tmp, wordList.get(j)) == 1) {
                            queue.offer(wordList.get(j));
                            wordList.remove(j);
                            j -= 1;
                        }
                    }
                }
            }
            return 0;
        }

        static private int compare(String s1, String s2) {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            int diff = 0;
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] != c2[i]) {
                    diff += 1;
                }
            }
            switch (diff) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                default:
                    return -1;
            }
        }
    }
}
