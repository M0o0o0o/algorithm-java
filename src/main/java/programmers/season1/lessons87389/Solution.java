package programmers.season1.lessons87389;

import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return IntStream.range(1, n).filter(num -> n % num == 1).findFirst().getAsInt();
    }
}