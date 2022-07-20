package programmers.competitions2627_1.problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(sol.solution(new int[]{5, 4, 3, 2, 1}));
    }


}