package programmers.kakao2022.one;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        System.out.println(Arrays.toString(solution1));




    }
}

