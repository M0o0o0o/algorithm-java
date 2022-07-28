package programmers.competitions2.problem2;

import org.junit.jupiter.api.Test;
import java.util.HashMap;

class Solution {
    int ans = 0;
    public int solution(int[] topping) {
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> left = new HashMap<>();
        int len = topping.length;
        for (int i = 0; i < len; i++) add(right, topping[i]);

        for (int i = 0; i < len; i++) {
            right.put(topping[i], right.get(topping[i]) - 1);
            add(left, topping[i]);
            if (right.get(topping[i]) == 0) right.remove(topping[i]);
            if (right.size() == left.size()) ans++;
        }
        return ans;
    }

    public void add(HashMap<Integer, Integer> target, int key) {
        if (target.containsKey(key)) {
            target.put(key, target.get(key) + 1);
        } else {
            target.put(key, 1);
        }
    }

    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 3, 1, 4}));
    }
}
