package com.github.cwdtom.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/description/
 * Dijkstra 有向权重图算法
 *
 * @author chenweidong
 */
public class NetworkDelayTime743 {
    public static void main(String[] args) {
        System.out.println(
                new NetworkDelayTime743.Solution().networkDelayTime(
                        new int[][]{{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}}, 4, 1)
        );
    }

    static class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, List<Node>> graph = new HashMap<>(times.length);
            Map<Integer, Integer> path = new HashMap<>(times.length);
            for (int[] t : times) {
                List<Node> list = graph.get(t[0]);
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(new Node(t[2], t[1]));
                graph.put(t[0], list);
                path.put(t[0], Integer.MAX_VALUE);
                path.put(t[1], Integer.MAX_VALUE);
            }
            if (path.size() != N) {
                return -1;
            }

            path.put(K, 0);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(K);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int index = queue.poll();
                    int time = path.get(index);
                    if (graph.get(index) == null) {
                        continue;
                    }
                    for (Node n : graph.get(index)) {
                        if (path.get(n.target) > time + n.time) {
                            path.put(n.target, time + n.time);
                            queue.offer(n.target);
                        }
                    }
                }
            }

            int max = -1;
            for (Integer value : path.values()) {
                if (value > max) {
                    max = value;
                }
                if (value == Integer.MAX_VALUE) {
                    return -1;
                }
            }
            return max;
        }

        class Node {
            int time;
            int target;

            Node(int time, int target) {
                this.time = time;
                this.target = target;
            }
        }
    }
}
