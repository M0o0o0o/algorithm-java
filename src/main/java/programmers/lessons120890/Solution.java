package programmers.lessons120890;

import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        int ans = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;


        Arrays.sort(array);

        for (int num : array) {
            if (Math.abs(num - n) < min) {
                ans = num;
                min = Math.abs(num - n);
            }
        }

        return ans;
    }
}