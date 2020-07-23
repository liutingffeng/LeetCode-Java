package LCSolution;

import java.util.*;

public class LC127 {

    class Solution {
        //图的BFS
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordSet = new HashSet<>();
            for (String s: wordList){
                wordSet.add(s);
            }
            if (wordSet.size() == 0 || !wordSet.contains(endWord))
                return 0;
            wordSet.remove(beginWord);
            int step = 0;
            HashSet<String> visited = new HashSet<>();
            // 图的广度优先遍历，必须使用的队列和表示是否访问过的 visited （数组，哈希表）
            Deque<String> deque = new ArrayDeque<>();
            deque.addLast(beginWord);
            while (!deque.isEmpty()){
                step ++;
                int currentSize = deque.size();
                while (currentSize-->0){
                    String word = deque.pollFirst();
                    char[] charArray = word.toCharArray();
                    for (int i=0;i<word.length();i++){
                        char origin = charArray[i];
                        for (char j='a';j<='z';j++){
                            if (j == origin)
                                continue;
                            charArray[i] = j;
                            String nextStr = String.valueOf(charArray);
                            if (endWord.equals(nextStr))
                                return step+1;
                            if (wordSet.contains(nextStr) && !visited.contains(nextStr)){
                                visited.add(nextStr);
                                deque.addLast(nextStr);
                            }
                        }
                        charArray[i] = origin;
                    }
                }
            }
            return 0;
        }

        //双向BFS
//        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//            HashSet<String> wordSet = new HashSet<>();
//            for (String s: wordList){
//                wordSet.add(s);
//            }
//            if (wordSet.size() == 0 || !wordSet.contains(endWord))
//                return 0;
//            wordSet.remove(beginWord);
//            int step = 0;
//            // 标准写法，总的 visited 数组
//            HashSet<String> visited = new HashSet<>();
//            // 图的广度优先遍历，必须使用的队列和表示是否访问过的 visited （数组，哈希表）
//            // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列
//            Set<String> beginVisited = new HashSet<>();
//            beginVisited.add(beginWord);
//
//            Set<String> endVisited = new HashSet<>();
//            endVisited.add(endWord);
//
//            int len = beginWord.length();
//            while (!beginVisited.isEmpty()){
//                step ++;
//
//                // 优先选择小的哈希表进行扩散，考虑到的情况更少
//                if (beginVisited.size() > endVisited.size()){
//                    Set<String> temp = beginVisited;
//                    beginVisited = endVisited;
//                    endVisited = temp;
//                }
//
//                // 逻辑到这里，保证 beginVisited 是相对较小的集合
//                // nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
//                Set<String> nextLevelVisited = new HashSet<>();
//
//                for (String word:beginVisited){
//                    char[] charArray = word.toCharArray();
//                    for (int i=0;i<word.length();i++){
//                        char origin = charArray[i];
//                        for (char j='a';j<='z';j++){
//                            if (j == origin)
//                                continue;
//                            charArray[i] = j;
//                            String nextStr = String.valueOf(charArray);
//                            if (endVisited.contains(nextStr))
//                                return step+1;
//                            if (wordSet.contains(nextStr) && !visited.contains(nextStr)){
//                                visited.add(nextStr);
//                                nextLevelVisited.add(nextStr);
//                            }
//                        }
//                        charArray[i] = origin;
//                    }
//                }
//                beginVisited = nextLevelVisited;
//            }
//            return 0;
//        }
    }
}
