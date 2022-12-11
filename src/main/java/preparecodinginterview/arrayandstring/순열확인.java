package preparecodinginterview.arrayandstring;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 문자열 두 개가 주어졌을 때, 이 둘이 서로 순열 관계에 있는지 확인하는 메서드를 작성하라.
 */
public class 순열확인 {

    public String solve(String string1, String string2) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string1.length(); i++) {
            char c = string1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                continue;
            }
            map.put(c, 1);
        }

        boolean ans = true;

        for (int i = 0; i < string2.length(); i++) {
            char c = string2.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0) {
                ans = false;
                break;
            }

            map.put(c, map.get(c) - 1);
        }

        if(ans) return "YES";
        else return "NO";
    }

    @Test
    void 순열인경우() {
        solve("hello", "ollhe");
    }

    @Test
    void 순열이아닌경우() {
        solve("hello", "ollhee");
    }
}

