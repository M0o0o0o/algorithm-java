package programmers.kakao2022.five;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] solution1 = solution.solution(
                new String[]{
                        "UPDATE 1 1 a",
                        "UPDATE 1 2 b",
                        "UPDATE 2 1 c",
                        "UPDATE 2 2 d",
                        "MERGE 1 1 1 2",
                        "MERGE 2 2 2 1",
                        "MERGE 2 1 1 1",
                        "PRINT 1 1",
                        "UNMERGE 2 2",
                        "PRINT 1 1"
                }
        );
//
//        String[] solution1 = solution.solution(
//                new String[]{
//                        "UPDATE 1 1 menu",
//                        "UPDATE 1 2 category",
//                        "UPDATE 2 1 bibimbap",
//                        "UPDATE 2 2 korean",
//                        "UPDATE 2 3 rice",
//                        "UPDATE 3 1 ramyeon",
//                        "UPDATE 3 2 korean",
//                        "UPDATE 3 3 noodle",
//                        "UPDATE 3 4 instant",
//                        "UPDATE 49 49 instant",
//                        "UPDATE 50 50 instant",
//                        "MERGE 49 49 50 50",
//                        "PRINT 50 50",
//                        "UNMERGE 50 50",
//                        "UPDATE 4 1 pasta",
//                        "UPDATE 4 2 italian",
//                        "UPDATE 4 3 noodle",
//                        "MERGE 1 2 1 3",
//                        "MERGE 1 3 1 4",
//                        "UPDATE korean hansik",
//                        "UPDATE 1 3 group",
//                        "UNMERGE 1 4",
//                        "PRINT 1 3",
//                        "PRINT 1 4",
//                }
//        );

//        "MERGE 1 2 1 3",
//                "MERGE 1 3 1 4",
//                "UPDATE korean hansik",
//                "UPDATE 1 3 group",
//                "UNMERGE 1 4",
//                "PRINT 1 3",
//                "PRINT 1 4"
        System.out.println(Arrays.toString(solution1));

        System.out.println("" + 1 + 50);

    }
}
