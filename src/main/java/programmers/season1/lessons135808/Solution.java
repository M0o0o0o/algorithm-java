package programmers.season1.lessons135808;

import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int len = score.length;
        int idx = len % m;

        int ans = 0;
        while (idx < len) {
            ans += score[idx] * m;
            idx += m;
        }

        return ans;
    }
}