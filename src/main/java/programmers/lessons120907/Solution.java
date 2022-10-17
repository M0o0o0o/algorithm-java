package programmers.lessons120907;

import org.junit.jupiter.api.Test;

class Solution {
    public String[] solution(String[] quiz) {
        String[] ans = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] str = quiz[i].split(" ");
            if (str[1].equals("-")) {
                ans[i] = (Integer.valueOf(str[0]) - Integer.valueOf(str[2])) == Integer.valueOf(str[4]) ? "O" : "X";
                continue;
            }
            ans[i] = (Integer.valueOf(str[0]) + Integer.valueOf(str[2])) == Integer.valueOf(str[4]) ? "O" : "X";

        }
        return ans;
    }
}