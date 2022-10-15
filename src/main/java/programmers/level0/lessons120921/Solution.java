package programmers.level0.lessons120921;


import org.junit.jupiter.api.Test;

class Solution {
    public int solution(String A, String B) {
        int cnt = 0;
        for (int i = 0; i <= B.length(); i++) {
            if (A.equals(B)) {
                return cnt;
            }
            cnt++;
            A = A.charAt(A.length() - 1) + A.substring(0, A.length()-1);
        }
        return -1;
    }
}
