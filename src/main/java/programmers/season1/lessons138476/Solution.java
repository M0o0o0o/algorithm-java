package programmers.season1.lessons138476;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer value : map.values()) {
            pq.add(value);
        }

        int cnt = 0;
        int answer = 0;

        while (true) {
            cnt += pq.poll();
            answer++;
            if(cnt >= k) break;
        }
        return answer;
    }
}