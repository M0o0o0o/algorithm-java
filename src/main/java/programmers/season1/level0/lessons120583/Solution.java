package programmers.season1.level0.lessons120583;

import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        return (int)Arrays.stream(array).filter(num -> num == n).count();
    }
}