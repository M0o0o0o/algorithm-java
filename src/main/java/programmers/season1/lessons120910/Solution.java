package programmers.season1.lessons120910;

class Solution {
    public int solution(int n, int t) {
        for (int i = 0; i < t; i++) n *= 2;
        return n;
    }
}