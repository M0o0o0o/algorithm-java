package programmers.season1.lessons140108;

class Solution {

    private final static char INIT = '_';
    public int solution(String s) {
        int ans = 0;
        int readCount = 0;
        char baseChar = INIT;
        int baseCharCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (baseChar == INIT) {
                baseChar = s.charAt(i);
                readCount++;
                baseCharCount++;
                continue;
            }

            readCount++;
            if (s.charAt(i) == baseChar) {
                baseCharCount++;
            }

            if (readCount - baseCharCount == baseCharCount) {
                ans++;
                baseChar = INIT;
                readCount = 0;
                baseCharCount = 0;
            }

        }
        if(baseChar != INIT) ans++;

        return ans;
    }
}