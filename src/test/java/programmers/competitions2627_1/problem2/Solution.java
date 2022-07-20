package programmers.competitions2627_1.problem2;

import java.util.HashMap;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    int len;
    public int solution(String[] want, int[] number, String[] discount) {
        len = number.length;
        for (int i = 0; i < len; i++) {
            map.put(want[i], number[i]);
        }
        int ans = 0;
        for (int i = 9; i < discount.length; i++) {
            calc(i - 9, i, discount);
            if (check(want)) {
                ans++;
            }
            init(want, number);
        }
        return ans;

    }

    public boolean check(String[] want) {
        for (int i = 0; i < len; i++) {
            if(map.get(want[i]) != 0) return false;
        }
        return true;
    }

    public void calc(int start, int end, String[] discount) {
        for (int i = start; i <= end; i++) {
            if (map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }
    }

    public void init(String[] want, int[] number) {
        for (int i = 0; i < len; i++) {
            map.put(want[i], number[i]);
        }
    }
}