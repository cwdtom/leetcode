package com.github.cwdtom.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/course-schedule-iii/description/
 * 贪心算法
 *
 * @author chenweidong
 */
public class CourseScheduleIII630 {

    public static void main(String[] args) {
        System.out.println(
                new CourseScheduleIII630.Solution().scheduleCourse(
                        new int[][]{{5, 5}, {4, 6}, {2, 6}})
        );
    }

    static class Solution {
        public int scheduleCourse(int[][] courses) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
            int time = 0;
            for (int[] c : courses) {
                time += c[0];
                pq.offer(c[0]);
                if (time > c[1]) {
                    time -= pq.poll();
                }
            }
            return pq.size();
        }
    }
}
