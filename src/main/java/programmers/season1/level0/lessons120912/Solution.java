package programmers.season1.level0.lessons120912;

class Solution {
    public int solution(int[] array) {
        int answer = 0;

        for (int num : array) {
            String numToStr = String.valueOf(num);
            for (int i = 0; i < numToStr.length(); i++) {
                if (numToStr.charAt(i) == '7') {
                    answer++;
                }
            }
        }
        return answer;
    }
}