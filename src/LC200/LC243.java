package LC200;

/**
 * 给定一个字符串数组 wordDict 和两个已经存在于该数组中的不同的字符串 word1 和 word2 。返回列表中这两个单词之间的最短距离。
 *
 *
 *
 * 示例 1:
 *
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * 输出: 3
 * 示例 2:
 *
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * 输出: 1
 *
 */
public class LC243 {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int x1 = -1, x2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1))
                x1 = i;
            if (wordsDict[i].equals(word2))
                x2 = i;
            if (x1 != -1 && x2 != -1)
                res = Math.min(res, Math.abs(x1 - x2));
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
