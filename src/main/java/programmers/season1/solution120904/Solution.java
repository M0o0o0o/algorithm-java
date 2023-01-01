package programmers.season1.solution120904;

class Solution {
    public int solution(int num, int k) {
        int index = String.valueOf(num).indexOf(String.valueOf(k));
        if (index != -1) {
            return index + 1;
        }
        return -1;
    }
}