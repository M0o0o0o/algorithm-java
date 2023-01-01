package programmers.season1.lessons120891;

class Solution {
    public int solution(int order) {
        String s = String.valueOf(order);
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '3' || c == '6' || c == '9') ans ++;
        }

        return ans;
    }
}
