package programmers.level0.lessons120923;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class Solution {
    public int[] solution(int num, int total) {
        int startWithNum = -1000;
        int sum = IntStream.range(-1000, -1000 + num).sum();
        for (int i = -1000 + num; i <= 1001; i++) {
            sum -= startWithNum++;
            sum += i;
            if(total == sum) break;
        }
        return IntStream.range(startWithNum, startWithNum + num).toArray();
    }

}