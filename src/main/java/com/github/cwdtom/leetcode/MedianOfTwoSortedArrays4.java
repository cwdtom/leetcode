package com.github.cwdtom.leetcode;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 把两个数组假设为*2的数组，例如{1, 2, 3}->{1, 1, 2, 2, 3, 3}，
 * 保证中位数不变的前提下方便选取切割点
 *
 * @author chenweidong
 */
public class MedianOfTwoSortedArrays4 {
    public static void main(String[] args) {
        System.out.println(
                new MedianOfTwoSortedArrays4.Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})
        );
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int size1 = nums1.length * 2, size2 = nums2.length * 2;
            int mid1 = nums1.length, mid2 = nums2.length;

            while (true) {
                int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
                int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
                int r1 = (mid1 == size1) ? Integer.MAX_VALUE : nums1[mid1 / 2];
                int r2 = (mid2 == size2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

                if (l1 > r2) {
                    mid1--;
                    mid2++;
                } else if (l2 > r1) {
                    mid1++;
                    mid2--;
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }
        }
    }
}
