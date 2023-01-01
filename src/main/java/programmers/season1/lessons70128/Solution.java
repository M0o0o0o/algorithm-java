package programmers.season1.lessons70128;


class Solution {
    public int solution(int[] a, int[] b) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += a[i] * b[i];
        }
        return ans;
    }
}