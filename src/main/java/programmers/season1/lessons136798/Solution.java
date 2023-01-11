package programmers.season1.lessons136798;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int number, int limit, int power) {
        int ans = 0;
        for (int i = 1; i <= number; i++) {
            int need = calc(i);
            if (need > limit) {
                ans += power;
                continue;
            }
            ans += need;
        }

        return ans;
    }

    private int calc(int number) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                set.add(i);
                set.add(number / i);
            }
        }
        return set.size();
    }

}