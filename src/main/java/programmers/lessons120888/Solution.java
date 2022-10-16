package programmers.lessons120888;

import java.util.HashSet;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < my_string.length(); i++) {
            char now = my_string.charAt(i);
            if(set.contains(now)) continue;
            sb.append(now);
            set.add(now);
        }
        return sb.toString();
    }
}