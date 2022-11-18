package programmers.lessons132267;

class Solution {
    public int solution(int a, int b, int n) {
        int ans = 0;

        while (n >= a) {
            ans += (n / a) * b;
            n = ((n / a) * b) + (n % a);
        }

        return ans;
    }
}