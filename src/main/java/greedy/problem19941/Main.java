package greedy.problem19941;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int n, k;
    static PriorityQueue<Integer> heapq = new PriorityQueue<>();
    static ArrayList<Integer> person = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        String str = sc.next();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'H') {
                heapq.add(i);
            } else {
                person.add(i);
            }
        }

        int ans = 0;
        for (int p : person) {
            while (!heapq.isEmpty()) {
                int burger = heapq.poll();
                if (Math.abs(p - burger) <= k) {
                    ans++;
                    break;
                } else {
                    if (burger > p) {
                        heapq.add(burger);
                        break;
                    }
                    continue;
                }
            }
        }
        System.out.println(ans);

        sc.close();
    }
}
