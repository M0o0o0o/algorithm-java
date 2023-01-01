package programmers.season1.lessons49993;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Character> orderMap = new HashMap<>();
        char[] charArray = skill.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            orderMap.put(charArray[i], charArray[i - 1]);
        }

        int ans = 0;
        for (String skill_tree : skill_trees) {
            if (check(skill_tree, orderMap))
                ans++;
        }

        return ans;
    }

    private boolean check(String skill_tree, Map<Character, Character> orderMap) {
        char[] charArray = skill_tree.toCharArray();
        Set<Character> islearned = new HashSet<>();
        for (Character character : charArray) {

            if (!orderMap.containsKey(character)) {
                islearned.add(character);
                continue;
            }

            if (!islearned.contains(orderMap.get(character))) return false;
            islearned.add(character);
        }

        return true;
    }
}