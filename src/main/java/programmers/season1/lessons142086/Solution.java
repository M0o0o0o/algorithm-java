package programmers.season1.lessons142086;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> store = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!store.containsKey(c)) {
                store.put(c, i);
                ans.add(-1);
                continue;
            }
            ans.add(i - store.get(c));
            store.put(c, i);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}