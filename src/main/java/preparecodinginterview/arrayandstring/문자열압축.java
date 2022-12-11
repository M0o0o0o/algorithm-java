package preparecodinginterview.arrayandstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 문자열압축 {

    public String solve(String given) {
        StringBuilder sb = new StringBuilder();
        char now = given.charAt(0);
        int cnt = 1;

        for (int i = 1; i < given.length(); i++) {
            char c = given.charAt(i);
            if (now == c) {
                cnt++;
                continue;
            }


            sb.append(now);
            sb.append(cnt);
            now = c;
            cnt = 1;
        }
        sb.append(now);
        sb.append(cnt);

        if (sb.length() > given.length()) {
            return given;
        } else {
            return sb.toString();
        }
    }

    @Test
    void 압축한길이가더짧은경우() {
        String before = "aabccccaaa";
        String after = "a2b1c4a3";
        assertEquals(solve(before), after);
    }

    @Test
    void 압축한길이가더긴경우() {
        String before = "asdfghjkl";
        String after = "asdfghjkl";

        assertEquals(solve(before), after);

    }
}
