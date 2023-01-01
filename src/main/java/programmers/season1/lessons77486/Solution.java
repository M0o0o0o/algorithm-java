package programmers.season1.lessons77486;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] ans = new int[enroll.length];

        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String current = seller[i];
            int earn = 100 * amount[i];

            while (!current.equals("-")) {
                int forParent = earn / 10;
                int nowProfit = earn - forParent;

                ans[index.get(current)] += nowProfit;

                current = parent.get(current);
                earn /= 10;

                if (earn < 1) {
                    break;
                }
            }
        }

        return ans;
    }

}