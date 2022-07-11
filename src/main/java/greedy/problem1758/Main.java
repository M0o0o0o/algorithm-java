package greedy.problem1758;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int n;
    static PriorityQueue<Integer> heapq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            heapq.add(sc.nextInt());
        }

        int cnt = 0;
        long ans = 0;
        while (!heapq.isEmpty()) {
            int now = heapq.poll() - (cnt++);
            if(now < 0) break;
            ans += now;

        }
        System.out.println(ans);

        sc.close();
    }
}


