package preparecodinginterview.arrayandstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 문자열에 들어 있는 모든 공백은 '%20'으로 바꿔주는 메서드를 작성하라.
 * 최종적으로 모든 문자를 다 담을 수 있을 만큼 충분한 공간이 이미 확보되어 있으며 문자열의 최종 길이가 함께 주어진다고 가정해도 된다.
 * (자바로 구현한다면 배열 안에서 작업할 수 있도록 문자 배열을 이용하길 권장)
 */
public class URL화 {

    private final String space = "%20";

    public String solve(String url) {
        StringBuilder sb = new StringBuilder();
        char[] array = url.toCharArray();

        for (char c : array) {
            if(c == ' ') sb.append(space);
            else sb.append(c);
        }

        return sb.toString();
    }

    @Test
    void 공백이주어진문자열() {
        String before = "lee moo yeol";
        String after = "lee" + space + "moo" + space + "yeol";

        Assertions.assertEquals(solve(before), after);
    }

}
