package com.github.cwdtom.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/description/
 * 先排序然后依次合并
 *
 * @author chenweidong
 */
public class InsertInterval57 {
    class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> result = new ArrayList<>();
            if (intervals.size() == 0) {
                result.add(newInterval);
                return result;
            }

            intervals.add(newInterval);
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
