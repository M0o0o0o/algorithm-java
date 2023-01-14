package programmers.season1.lessons147355;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        long pInt = Long.parseLong(p);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            sb.append(t.charAt(i));

            if(sb.length() < p.length()) continue;

            if (sb.length() > p.length()) {
                sb.deleteCharAt(0);
            }

            if (Long.parseLong(sb.toString()) <= pInt) {
                answer++;
            }

        }

        return answer;
    }
}