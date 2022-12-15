package programmers.lessons142085;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int ans = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);

            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                } else {
                    ans = i;
                    break;
                }
            }
        }

        return ans;
    }

    @Test
    void test() {
        int solution = solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
        System.out.println("solution = " + solution);
    }


    @Test
    void test2() {
        System.out.println(solution(2, 4, new int[]{3, 3, 3, 3}));
    }

}