package leetcode.str.medium.replaceWords_648;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceWords1(Arrays.asList("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
    }

    private final TrieTree trieTree = new TrieTree();

    /**
     * 使用Map解决
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> dictMap = new HashMap<>(dictionary.size());
        dictionary.forEach(dict -> {
            dictMap.put(dict, dict.length());
        });
        String[] sentrnceStrs = sentence.split(" ");
        List<String> sentList = Arrays.asList(sentrnceStrs);
        for (int i = 0; i < sentList.size(); i++) {
            String str = sentList.get(i);
            int minLen = str.length();
            for (Map.Entry<String, Integer> entry : dictMap.entrySet()) {
                if (str.startsWith(entry.getKey())) {
                    if ((minLen > entry.getValue()) || (entry.getValue() == 1 && str.length() == 1 && str.charAt(0) - entry.getKey().charAt(0) > 0)) {
                        str = entry.getKey();
                        minLen = entry.getValue();
                    }
                }
            }
            sb.append(str + " ");
        }
        return sb.toString().trim();
    }

    /**
     * 使用字典树解决
     */
    public String replaceWords1(List<String> dictionary, String sentence) {
        StringBuilder stringBuilder = new StringBuilder();
        buildTrieTree(dictionary);
        String[] strs = sentence.split(" ");
        for (String s : strs) {
            stringBuilder.append(trieTree.startWith(s)).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * 根据字典列表构建字典树
     */
    private void buildTrieTree(List<String> dictionary) {
        for (String s : dictionary) {
            trieTree.insert(s);
        }
    }
}

class TrieNode {
    boolean isEnd = false;

    TrieNode[] trieNodes = new TrieNode[26];
}

class TrieTree {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode tmp = root;
        for (char c : word.toCharArray()) {
            if (tmp.trieNodes[c - 'a'] == null) {
                tmp.trieNodes[c - 'a'] = new TrieNode();
            }
            tmp = tmp.trieNodes[c - 'a'];
        }
        tmp.isEnd = true;
    }

    String startWith(String prefix) {
        StringBuilder stringBuilder = new StringBuilder();
        TrieNode tmp = root;
        for (char c : prefix.toCharArray()) {
            if (tmp.trieNodes[c - 'a'] == null) return "-1";
            tmp = tmp.trieNodes[c - 'a'];
            stringBuilder.append(c);
            if (tmp.isEnd) return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }
}
