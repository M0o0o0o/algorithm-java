package programmers.level0.lessons120911;

import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        char[] charArray = my_string.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}