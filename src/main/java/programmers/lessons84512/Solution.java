package programmers.lessons84512;

import org.junit.jupiter.api.Test;

class Solution {
    char[] order = {'A', 'E', 'I', 'O', 'U'};
    int limit = 5;
    int answer = 0;
    boolean isFind = false;
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dfs(limit, sb, word);
        return answer;
    }

    private void dfs(int limit, StringBuilder sb, String word) {
        if (word.equals(sb.toString())) {
            isFind = true;
            return;
        }
        if(sb.length() == limit){
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        for (char c : order) {
            answer++;
            sb.append(c);
            dfs(limit, sb, word);
            if(isFind) break;
        }
        sb.deleteCharAt(sb.length() - 1);
        return;
    }

}