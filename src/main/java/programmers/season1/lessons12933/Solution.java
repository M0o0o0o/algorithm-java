package programmers.season1.lessons12933;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(String.valueOf(str.charAt(i)));
        }

        list.sort(Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            answer += Integer.valueOf(list.get(i));
            if (i < list.size() - 1) answer *= 10;
        }

        return answer;
    }
}