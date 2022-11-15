package programmers.lessons133502;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] ingredient) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        result.add(1);
        result.add(2);
        result.add(3);
        result.add(1);

        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
            if (list.size() >= 4) {
                if(check(list, result)){
                    remove(list);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void remove(List<Integer> list) {
        for (int i = 0; i < 4; i++) {
            list.remove(list.size() - 1);
        }
    }

    private boolean check(List<Integer> list, List<Integer> result) {
        for (int i = 0; i < 4; i++) {
            if (result.get(i) != list.get(list.size() - 4 + i)) {
                return false;
            }
        }
        return true;
    }

}

