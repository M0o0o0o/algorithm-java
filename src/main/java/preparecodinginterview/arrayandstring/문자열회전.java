package preparecodinginterview.arrayandstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class 문자열회전 {

    public boolean solve(String str1, String str2) {
        if(str1.length() != str2.length()) return false;

        StringBuilder sb = new StringBuilder(str1);

        for (int i = 0; i < str1.length(); i++) {
            if(sb.toString().equals(str2)) return true;
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }

        return false;
    }

    @Test
    void 회전시켜서동일한문자열인경우() {
        assertTrue(solve("waterbottle", "erbottlewat"));
    }

    @Test
    void 다른문자열인경우() {
        assertFalse(solve("waterbottee", "erbottlewat"));
    }
}
