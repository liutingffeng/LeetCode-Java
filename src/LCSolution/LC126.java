package LCSolution;

import java.util.*;

public class LC126 {

    class Solution {
        /*
第 1 步：使用广度优先遍历找到终点单词，并且记录下沿途经过的所有结点，以邻接表形式存储；
第 2 步：通过邻接表，使用回溯算法得到所有从起点单词到终点单词的路径。

       */
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
// 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
            Set<String> wordSet = new HashSet<>(wordList);
            List<List<String>> res = new ArrayList<>();
            if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
                return res;
            }

            // 第 1 步：使用广度优先遍历得到后继结点列表 successors
            // key：字符串，value：广度优先遍历过程中 key 的后继结点列表
            Map<String, Set<String>> successors = new HashMap<>();
            boolean found = bfs(beginWord, endWord, wordSet, successors);
            if (!found) {
                return res;
            }

            // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表
            Deque<String> path = new ArrayDeque<>();
            path.addLast(beginWord);
            dfs(beginWord, endWord, successors, path, res);
            return res;

        }

        private void dfs(String beginWord, String endWord, Map<String, Set<String>> successors, Deque<String> path, List<List<String>> res) {
            if (beginWord.equals(endWord)){
                res.add(new ArrayList<>(path));
                return;
            }
            if (!successors.containsKey(beginWord)){
                return;
            }

            Set<String> successorSet = successors.get(beginWord);
                for (String nexStr :successorSet){
                    path.addLast(nexStr);
                    dfs(nexStr, endWord, successors, path, res);
                    path.removeLast();
                }
            }
        }

        private boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            // 记录访问过的单词
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            boolean found = false;
            int wordLen = beginWord.length();
            // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
            Set<String> nextLevelVisited = new HashSet<>();

            while (!queue.isEmpty()){
                int currentSize = queue.size();
                for (int i = 0; i < currentSize; i++) {
                    String word = queue.poll();
                    char[] wordArray = word.toCharArray();
                    for (int j = 0; j < wordLen; j++) {
                        char origin = wordArray[j];
                        for (char k='a';k<='z';k++){
                            if (k==origin)
                                continue;
                            wordArray[j] = k;
                            String nextStr = new String(wordArray);
                            if (wordSet.contains(nextStr)){
                                if (!visited.contains(nextStr)){
                                    if (nextStr.equals(endWord)){
                                        found = true;
                                    }
                                    nextLevelVisited.add(nextStr);
                                    queue.offer(nextStr);

                                    // 维护 successors 的定义
                                    successors.computeIfAbsent(word, (a)->new HashSet<>());
                                    successors.get(word).add(nextStr);
                                }
                            }
                        }
                        wordArray[j] = origin;
                    }
                }

                if (found)
                    break;
                visited.addAll(nextLevelVisited);
                nextLevelVisited.clear();
            }
            return found;
        }

}
