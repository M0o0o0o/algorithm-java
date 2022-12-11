package preparecodinginterview.arrayandstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class 회문순열 {
    public boolean solve(String given) {
        boolean ans = true;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < given.length(); i++) {
            char c = given.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                continue;
            }
            map.put(c, 1);
        }

        boolean isFindoneAlready = false;
        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                if (!isFindoneAlready) {
                    isFindoneAlready = true;
                    continue;
                }
                ans = false;
                break;
            }

            if (map.get(c) % 2 != 0) {
                ans = false;
                break;
            }
        }

        return ans;
    }

    @Test
    void 회문순열인경우() {
        assertTrue(solve("ehehl"));
    }

    @Test
    void 회문순열이아닌경우() {
        assertFalse(solve("ehehlp"));
    }
}
