package preparecodinginterview.arrayandstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는 지 확인하는 알고리즘을 작성하라.
 * 자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한 고민하라.
 */
public class 중복이없는가 {

    // 자료구조를 사용한 알고리즘
    public boolean solve1(String data) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (set.contains(c)) { // 중복 발생
                return true;
            }

            set.add(c);
        }
        return false; // 해당 문자열에서 중복 찾기 못함
    }

    // 자료구조를 사용하지 않은 경우
    public boolean solve2(String data) {
        char[] charArray = data.toCharArray();
        Arrays.sort(charArray);

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void solve1WithduplecatedString() {
        assertTrue(solve1("duetneoquadd"));
    }

    @Test
    public void solve1WithnonDuplicatedString() {
        assertFalse(solve1("asdfgzxcvb"));
    }

    @Test
    public void solve2WithduplecatedString() {
        assertTrue(solve2("duetneoquadd"));
    }

    @Test
    public void solve2WithnonDuplicatedString() {
        assertFalse(solve2("asdfgzxcvb"));
    }
}
