package leetcode.str.easy.validAnagram_242;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 桶排序
    public boolean isAnagram(String s, String t) {
        if ((s == null && t != null) || (s != null && t == null) || (s.length() != t.length())) return false;
        // 桶排序
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            bucket[c - 'a']--;
        }
        for (int i : bucket) {
            if (i != 0) return false;
        }
        return true;
    }

    // 常规方法
    public boolean isAnagram1(String s, String t) {
        if ((s == null && t != null) || (s != null && t == null) || (s.length() != t.length())) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}
