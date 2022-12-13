package programmers.lessons118667;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long target = (getSum(queue1) + getSum(queue2)) / 2;
        long leftSum = getSum(queue1);

        int cnt = 0;

        if (getMax(queue1) > target || getMax(queue2) > target) {
            return -1;
        }

        Queue<Integer> lq = getQueue(queue1);
        Queue<Integer> rq = getQueue(queue2);

        while (!lq.isEmpty() && !rq.isEmpty()) {
            if (leftSum > target) {
                leftSum -= lq.poll();
                cnt++;
            } else if (leftSum < target) {
                Integer num = rq.poll();
                lq.add(num);
                leftSum += num;
                cnt++;
            } else {
                return cnt;
            }
        }
        return -1;
    }

    private Queue<Integer> getQueue(int[] queue) {
        Queue<Integer> q = new LinkedList<>();
        for (int num : queue) {
            q.add(num);
        }
        return q;
    }

    private int getMax(int[] queue) {
        int max = Integer.MIN_VALUE;
        for (int num : queue) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    private long getSum(int[] queue1) {
        long sum = 0l;
        for (int num : queue1) {
            sum += num;
        }
        return sum;
    }
}