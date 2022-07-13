package greedy.problem1700;

import java.io.BufferedReader;
import java.util.*;

//https://www.acmicpc.net/problem/1700
public class Main {
    static int[] list;
    static HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    static HashSet<Integer> tap = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        list = new int[k];
        for (int i = 0; i < k; i++) {
            int now = sc.nextInt();
            list[i] = now;
            if (!map.containsKey(now)) map.put(now, new PriorityQueue<>());
            map.get(now).add(i);
        }

        int ans = 0;
        for (int now : list) {
            if (tap.size() < n) {
                tap.add(now);
                map.get(now).poll();
                continue;
            }
            if (tap.contains(now)) {
                map.get(now).poll();
                continue;
            }
            int target = 0;
            int idx = -1;
            for (Integer candidate : tap) {
                if (map.get(candidate).size() == 0) {
                    target = candidate;
                    break;
                }
                if (map.get(candidate).peek() > idx) {
                    target = candidate;
                    idx = map.get(candidate).peek();
                }
            }

            tap.remove(target);
            tap.add(now);
            map.get(now).poll();
            ans++;
        }
        System.out.println(ans);

        sc.close();
    }
}
