package programmers.season1.level0.lessons120913;

class Solution {
    public String[] solution(String my_str, int n) {
        StringBuilder sb = new StringBuilder();
        int resultLen = my_str.length() / n + (my_str.length() % n > 0 ? 1 : 0);
        String[] result = new String[resultLen];
        int index = 0;
        int cnt = 0;
        for (char c : my_str.toCharArray()) {
            sb.append(c);
            cnt++;

            if (cnt == n) {
                result[index++] = sb.toString();
                sb = new StringBuilder();
                cnt = 0;
            }
        }
        if(sb.length() > 0) result[index++] = sb.toString();
        return result;
    }

}