package programmers.season1.lessons120884;

class Solution {
    public int solution(int chicken) {
        int ans = 0;
        while (chicken >= 10) {
            ans += chicken / 10;
            chicken = (chicken / 10) + (chicken % 10);
        }
        return ans;
    }
}