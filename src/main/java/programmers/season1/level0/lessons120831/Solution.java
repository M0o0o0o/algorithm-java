package programmers.season1.level0.lessons120831;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int n) {
        return IntStream.range(1, n + 1).filter(num -> num % 2 == 0).sum();
    }
}

