package programmers.lessons120886;


import java.util.HashMap;

class Solution {
    public int solution(String before, String after) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < before.length(); i++) {
            char letter = before.charAt(i);
            if(map.containsKey(letter)) map.put(letter, map.get(letter) + 1);
            else map.put(letter, 1);
        }

        for (int i = 0; i < after.length(); i++) {
            char letter = after.charAt(i);
            if(!map.containsKey(letter) || map.get(letter) == 0) return 0;
            map.put(letter, map.get(letter) - 1);
        }

        return 1;
    }
}