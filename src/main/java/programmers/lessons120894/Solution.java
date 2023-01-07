package programmers.lessons120894;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> map = new HashMap<>() {{
        put("zero", 0);
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four",4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight" , 8);
        put("nine", 9);
    }};

    public long solution(String numbers) {
        StringBuilder number = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < numbers.length(); i++) {
            number.append(numbers.charAt(i));
            if (map.containsKey(number.toString())) {
                ans.append(map.get(number.toString()));
                number.setLength(0);
            }
        }

        return Long.parseLong(ans.toString());
    }
}