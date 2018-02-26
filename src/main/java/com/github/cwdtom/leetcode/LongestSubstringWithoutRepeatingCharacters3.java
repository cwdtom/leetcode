package com.github.cwdtom.leetcode;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * @author chenweidong
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] cs = s.toCharArray();
            if (cs.length == 0) {
                return 0;
            }
            int head = 0, tail = 0, len = 0;
            while (tail < cs.length) {
                boolean isLegal = true;
                for (int i = head; i < tail; i++) {
                    if (cs[i] == cs[tail]) {
                        isLegal = false;
                        break;
                    }
                }
                if (!isLegal) {
                    head += 1;
                } else {
                    if (tail - head > len) {
                        len = tail - head;
                    }
                    tail += 1;
                }
            }
            return len + 1;
        }
    }
}
