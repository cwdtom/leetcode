package com.github.cwdtom.leetcode;

/**
 * https://leetcode.com/problems/two-sum/description/
 *
 * @author chenweidong
 */
public class TwoSum1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int another = target - nums[i];
                for (int j = i + 1; j < len; j++) {
                    if (another == nums[j]) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }
}
