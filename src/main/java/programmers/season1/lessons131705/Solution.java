package programmers.season1.lessons131705;

class Solution {
    public int solution(int[] number) {
        int ans = 0;

        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

}