package programmers.level0.lessons120806;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        int ans = solution.solution(3, 2);

        assertEquals(ans, 1500);

    }
}