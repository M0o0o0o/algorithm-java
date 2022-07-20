package programmers.competitions2627_1.problem1;

import java.util.HashMap;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Character, Integer> xstore = new HashMap<>();
        HashMap<Character, Integer> ystore = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
            char num = X.charAt(i);
            if (xstore.containsKey(num)) {
                xstore.put(num, xstore.get(num) + 1);
            } else {
                xstore.put(num, 1);
            }
        }

        for (int i = 0; i < Y.length(); i++) {
            char num = Y.charAt(i);
            if (ystore.containsKey(num)) {
                ystore.put(num, ystore.get(num) + 1);
            } else {
                ystore.put(num, 1);
            }
        }

        char[] nums = {'9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};
        boolean nothing = true;
        boolean isNotZero = false;
        StringBuilder sb = new StringBuilder();
        for (char num : nums) {
            if(!xstore.containsKey(num) || !ystore.containsKey(num)) continue;
            nothing = false;
            if(num != '0') isNotZero = true;
            int minCnt = Math.min(xstore.get(num), ystore.get(num));
            for (int i = 0; i < minCnt; i++) {
                sb.append(num);
            }
        }
        if(nothing) return "-1";
        if(!isNotZero) return "0";
        return sb.toString();
    }
}