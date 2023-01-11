package programmers.season1.lessons138477;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int k, int[] score) {
        Queue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            if (pq.size() > k) {
                pq.poll();
            }

            ans[i] = pq.peek();
        }
        return ans;
    }
}