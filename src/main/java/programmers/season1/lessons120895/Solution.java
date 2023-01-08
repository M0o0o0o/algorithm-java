package programmers.season1.lessons120895;


class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] charArray = my_string.toCharArray();
        char buf = charArray[num1];
        charArray[num1] = charArray[num2];
        charArray[num2] = buf;

        return String.valueOf(charArray);
    }
}