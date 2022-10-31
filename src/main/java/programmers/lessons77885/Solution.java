package programmers.lessons77885;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
    public long[] solution(long[] numbers) {
        long[] ans = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            ans[i] = calc(numbers[i]);
        }
        return ans;
    }

    private long calc(long number) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(number));
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.replace(i, i + 1, "1");
                int index = sb.indexOf("1", i + 1);
                if (index != -1) {
                    sb.replace(index, index + 1, "0");
                }
                return Long.valueOf(sb.toString(), 2);
            }
        }
        return Long.valueOf("10" + sb.substring(1), 2);
    }
}


