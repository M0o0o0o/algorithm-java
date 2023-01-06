package programmers.lessons120892;

class Solution {
    public String solution(String cipher, int code) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            if ((i+1) % code == 0) {
                ans.append(cipher.charAt(i));
            }
        }
        return ans.toString();
    }

}
