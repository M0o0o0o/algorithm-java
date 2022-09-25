package programmers.lessons120899;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array) {
        int idx = 0;
        int num = array[0];

        for (int i = 1; i < array.length; i++) {
            if (num < array[i]) {
                idx = i;
                num = array[i];
            }
        }

        return new int[]{num, idx};
    }
}