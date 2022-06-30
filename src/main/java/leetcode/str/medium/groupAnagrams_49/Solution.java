package leetcode.str.medium.groupAnagrams_49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        // key：存放每次字母中字符的次数
        // value：存放出现相同字符次数的字母集合
        Map<Map<Character, Integer>, List<String>> helpMap = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> tmpMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                tmpMap.put(c, tmpMap.getOrDefault(c, 0) + 1);
            }
            List<String> list;
            if (helpMap.containsKey(tmpMap)) {
                list = helpMap.get(tmpMap);
            } else {
                list = new ArrayList<>();
            }
            list.add(s);
            helpMap.put(tmpMap, list);
        }
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : helpMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
