package programmers.competitions2627_1.problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken","apple","apple","banana","rice","apple","pork","banana","pork","rice","pot","banana","apple","banana"}
        ));

        System.out.println(sol.solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));

    }



}