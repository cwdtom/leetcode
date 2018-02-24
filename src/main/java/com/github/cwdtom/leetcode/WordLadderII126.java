package com.github.cwdtom.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/description/
 * 先用bfs构建邻接表和距离表，然后通过dfs从终点反向求出所有结果集合
 *
 * @author chenweidong
 */
public class WordLadderII126 {
    public static void main(String[] args) {
        List<String> wordList = new LinkedList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(
                new Solution().findLadders("hit", "cog", wordList)
        );
    }

    static class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            // 必须要转成set调用，否则必然TLE
            Set<String> wordSet = new HashSet<>(wordList);
            wordSet.add(beginWord);
            List<List<String>> res = new ArrayList<>();

            if (!wordSet.contains(endWord)) {
                return res;
            }

            List<String> path = new LinkedList<>();
            Map<String, List<String>> graph = new HashMap<>(wordSet.size());
            Map<String, Integer> dist = new HashMap<>(wordSet.size());

            bfs(graph, dist, beginWord, wordSet);
            dfs(res, path, endWord, beginWord, dist, graph);

            return res;
        }

        static void bfs(Map<String, List<String>> graph, Map<String, Integer> dist,
                        String beginWord, Set<String> wordSet) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            dist.put(beginWord, 0);
            for (String w : wordSet) {
                graph.put(w, new ArrayList<>());
            }

            while (!queue.isEmpty()) {
                String word = queue.poll();
                List<String> neighbors = getNeighbors(word, wordSet);
                for (String neighbor : neighbors) {
                    graph.get(neighbor).add(word);
                    if (!dist.containsKey(neighbor)) {
                        dist.put(neighbor, dist.get(word) + 1);
                        queue.offer(neighbor);
                    }
                }
            }
        }

        static void dfs(List<List<String>> res, List<String> path, String word, String beginWord,
                        Map<String, Integer> dist, Map<String, List<String>> graph) {
            if (word.equals(beginWord)) {
                path.add(0, word);
                res.add(new ArrayList<>(path));
                path.remove(0);
                return;
            }

            for (String neighbor : graph.get(word)) {
                if (dist.get(word) == dist.get(neighbor) + 1) {
                    path.add(0, word);
                    dfs(res, path, neighbor, beginWord, dist, graph);
                    path.remove(0);
                }
            }
        }

        static List<String> getNeighbors(String word, Set<String> wordSet) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch < 'z' + 1; ch++) {
                    char[] chs = word.toCharArray();
                    if (ch != chs[i]) {
                        chs[i] = ch;
                        String next = new String(chs);
                        if (wordSet.contains(next)) {
                            res.add(next);
                        }
                    }
                }
            }
            return res;
        }
    }
}


