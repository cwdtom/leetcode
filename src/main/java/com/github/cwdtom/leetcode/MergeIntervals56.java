package com.github.cwdtom.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 * 先排序
 *
 * @author chenweidong
 */
public class MergeIntervals56 {
    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            List<Interval> result = new ArrayList<>();
            if (intervals.size() == 0) {
                return result;
            }

            intervals.sort(Comparator.comparingInt(arg0 -> arg0.start));

            Interval point = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                if (point.end < intervals.get(i).start) {
                    result.add(point);
                    point = intervals.get(i);
                } else {
                    point.end = Math.max(point.end, intervals.get(i).end);
                }
            }
            result.add(point);
            return result;
        }
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
