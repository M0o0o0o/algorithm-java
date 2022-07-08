package programmers.lessons1838;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        assertEquals(1, sol.solution(3, 3, new int[][]{{1140,1200},{1150,1200},{1100,1200},{1210,1300},{1220,1280}}));
    }


}