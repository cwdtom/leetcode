package com.github.cwdtom.leetcode;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 * 动态规划dp
 *
 * @author chenweidong
 */
public class NumberOfLongestIncreasingSubsequence673 {
    public static void main(String[] args) {
        System.out.println(new NumberOfLongestIncreasingSubsequence673.Solution()
                .findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    static class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length, res = 0, maxLen = 0;
            int[] len =  new int[n], cnt = new int[n];
            for(int i = 0; i<n; i++){
                len[i] = cnt[i] = 1;
                for(int j = 0; j <i ; j++){
                    if(nums[i] > nums[j]){
                        if(len[i] == len[j] + 1) {
                            cnt[i] += cnt[j];
                        }
                        if(len[i] < len[j] + 1){
                            len[i] = len[j] + 1;
                            cnt[i] = cnt[j];
                        }
                    }
                }
                if(maxLen == len[i]) {
                    res += cnt[i];
                }
                if(maxLen < len[i]){
                    maxLen = len[i];
                    res = cnt[i];
                }
            }
            return res;
        }
    }
}
