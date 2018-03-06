package com.github.cwdtom.leetcode;

/**
 * https://leetcode.com/problems/patching-array/description/
 *
 * @author chenweidong
 */
public class PatchingArray330 {
    class Solution {
        public int minPatches(int[] nums, int n) {
            long max = 0;
            int cnt = 0;
            for (int i = 0; max < n;) {
                if (i >= nums.length || max < nums[i] - 1) {
                    max += max + 1;
                    cnt++;
                } else {
                    max += nums[i];
                    i++;
                }
            }
            return cnt;
        }
    }
}
