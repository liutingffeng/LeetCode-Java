package LC200;

/**
 * 给定一个字符串数组 wordsDict 和两个字符串 word1 和 word2 ，返回这两个单词在列表中出现的最短距离。
 *
 * 注意：word1 和 word2 是有可能相同的，并且它们将分别表示为列表中 两个独立的单词 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * 输出：1
 * 示例 2：
 *
 * 输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
 * 输出：3
 *
 */
public class LC245 {

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if (word1.equals(word2)) {
            return help2(wordsDict, word1, word2);
        } else {
            return help1(wordsDict, word1, word2);
        }
    }

    public int help1 (String[] wordsDict, String word1, String word2) {
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

    public int help2 (String[] wordsDict, String word1, String word2) {
        int x1 = -1, x2 = -1;
        int res = Integer.MAX_VALUE;
        boolean lastChangeIs1 = false;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (lastChangeIs1) {
                    x2 = i;
                    lastChangeIs1 = false;
                } else {
                    x1 = i;
                    lastChangeIs1 = true;
                }
            }
            if (x1 != -1 && x2 != -1)
                res = Math.min(res, Math.abs(x1 - x2));
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
