package programmers.season1.lessons120896;



import java.util.HashMap;

class Solution {
    public String solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            if(map.get(i) == 1) sb.append(i);
        }

        return sb.toString();
    }
}