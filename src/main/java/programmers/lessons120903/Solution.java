package programmers.lessons120903;

import java.util.HashSet;

class Solution {
    public int solution(String[] s1, String[] s2) {
        HashSet<String> set = new HashSet<>();
        for (String s : s1) {
            set.add(s);
        }

        int ans = 0;
        for (String s : s2) {
            if(set.contains(s)) ans++;
        }

        return ans;
    }
}