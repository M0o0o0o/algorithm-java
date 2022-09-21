package programmers.level0.lessons120831;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int solution1 = solution.solution(10);

        Assertions.assertEquals(solution1, 30);

    }
}