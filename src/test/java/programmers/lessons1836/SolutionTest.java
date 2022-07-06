package programmers.lessons1836;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assertions.assertEquals("ABCD", sol.solution(3, 3, new String[]{"DBA", "C*A", "CDB"}));
    }

}