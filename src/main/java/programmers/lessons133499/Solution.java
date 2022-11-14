package programmers.lessons133499;

import org.junit.jupiter.api.Test;

class Solution {
    public int solution(String[] babbling) {
        String[] canSay = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String s : babbling) {
            if(check(s, canSay)) answer++;
        }
        return answer;
    }

    private boolean check(String s, String[] canSay) {
        StringBuilder sb = new StringBuilder(s);
        int exceptIdx = -1;
        while (!sb.equals("")) {
            boolean isMatched = false;
            for (int i = 0; i < canSay.length; i++) {
                if(exceptIdx == i) continue;
                if(sb.length() < canSay[i].length()) continue;

                if (sb.substring(0, canSay[i].length()).equals(canSay[i])) {
                    exceptIdx = i;
                    isMatched = true;
                    sb.replace(0, canSay[i].length(), "");
                    break;
                }
            }
            if(!isMatched) break;
        }
        if (sb.toString().equals("")) {
            return true;
        }
        return false;
    }
}