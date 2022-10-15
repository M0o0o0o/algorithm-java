package programmers.level0.lessons120956;


import org.junit.jupiter.api.Test;

class Solution {
    public int solution(String[] babbling) {
        String[] p = new String[]{"aya", "ye", "woo", "ma"};
        int ans = 0;

        for (int i = 0; i < babbling.length; i++) {
            String s = babbling[i];


            int skip = -1;
            while (true) {
                boolean isMatch = false;
                for (int j = 0; j < p.length; j++) {
                    if(j == skip) continue;

                    if (s.startsWith(p[j])) {
                        skip = j;
                        isMatch = true;
                        s = s.substring(p[j].length());
                    }
                }
                if(!isMatch) break;
            }
            if (s.length() == 0) {
                ans++;
            }

        }

        return ans;
    }

}