package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC030 {

    class Solution {
//        public List<Integer> findSubstring(String s, String[] words) {
//            List<Integer> res = new ArrayList<>();
//            if (s.isEmpty() || words.length == 0)
//                return res;
//            // 这个hasjmap 存储单词
//            Map<String,Integer> allWords = new HashMap<>();
//            for (String word : words){
//                allWords.put(word, allWords.getOrDefault(word, 0)+1);
//            }
//            int wordlen = words[0].length();
//            int size = words.length;
//            // 这个存储从索引开始的子串的单词情况
//            Map<String,Integer> needWords = new HashMap<>();
//            // 匹配的单词个数
//            int num = 0;
//            // 开始匹配的位置
//            for (int i = 0; i < s.length()-wordlen*size+1; i++) {
//
//                while (num < size){
//                    // 阿获取单词
//                    String str = s.substring(i+num*wordlen, i+(num+1)*wordlen);
//                    if (allWords.containsKey(str)){
//                        needWords.put(str, needWords.getOrDefault(str, 0)+1);
//                        // 当前匹配的单词数超过words 里相应单词的个数，直接跳出循环
//                        if (needWords.get(str)>allWords.get(str)){
//                            break;
//                        }
//                    }  // 不包含直接跳出循环
//                    else {
//                        break;
//                    }
//                    num++;
//                }
//
//                // 满足要求添加进结果集中
//                if (num == size)
//                    res.add(i);
//
//                num = 0;
//                needWords.clear();
//            }
//            return res;
//        }

        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (s.isEmpty() || words.length == 0)
                return res;

            //单词数组中的单词的大小，个数，以及总长度
            int one_word = words[0].length();
            int word_num = words.length;
            int all_len = one_word*word_num;

            //建立单词->单词个数的映射
            Map<String,Integer> allWords = new HashMap<>();
            for (String word : words){
                allWords.put(word, allWords.getOrDefault(word, 0)+1);
            }

            for (int i = 0; i < one_word; i++) {
                //left和rigth表示窗口的左右边界，count用来统计匹配的单词个数
                int left = i;
                int right = i;
                int count = 0;

                Map<String,Integer> subWords = new HashMap<>();

                // 开始滑动窗口
                while (right+one_word <= s.length()){

                    //从s中提取一个单词拷贝到w
                    String w=s.substring(right,right+one_word);
                    right+=one_word;//窗口右边界右移一个单词的长度

                    //此单词不在words中，表示匹配不成功,然后重置单词个数、窗口边界、以及m2
                    if (!allWords.containsKey(w)){
                        count = 0;
                        left = right;
                        subWords.clear();
                    }
                    // 匹配成功
                    else {
                        subWords.put(w, subWords.getOrDefault(w, 0)+1);
                        count ++ ;
                        //一个单词匹配多次，需要缩小窗口，也就是left右移
                        while (subWords.get(w)>allWords.get(w)){
                            String l_w = s.substring(left,left+one_word);
                            count --;
                            if (subWords.get(l_w) == 1){
                                subWords.remove(l_w);
                            }
                            else {
                                subWords.put(l_w, subWords.get(l_w)-1);
                            }
                            left += one_word;
                        }
                        // 找到可行解
                        if (count == word_num){
                            res.add(left);
                        }
                    }
                }
            }
            return res;
        }
    }

}
