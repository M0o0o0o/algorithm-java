package programmers.level0.lessons120809;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers).map(num -> num * 2).toArray();
    }
}