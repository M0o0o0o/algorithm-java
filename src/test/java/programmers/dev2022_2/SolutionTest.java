package programmers.dev2022_2;

import org.junit.jupiter.api.Test;
import programmers.dev2022.dev2022_2.Solution;

class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        int solution1 = solution.solution(new String[]{"AABCA.QA", "AABC..QX", "BBBC.Y..", ".A...T.A", "....EE..", ".M.XXEXQ", "KL.TBBBQ"});
        System.out.println(solution1);

    }
}