package bfs.problem16562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 친구의 친구는 친구다라는 규칙을 이용해서
 * 최소 비용을 들여서 모든 친구를 사귀는 최소 비용을 출력해야 한다.
 */
public class Main {
    static int n,m, k;
    static int[] parents;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] min = new int[n + 1];
        parents = new int[n + 1];
        cost = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            min[i] = Integer.MAX_VALUE;
            cost[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(Math.min(from, to), Math.max(from, to));
        }

        for (int i = 1; i < n + 1; i++) {
            int root = find(i);
            min[root] = Math.min(min[root], cost[i]);
        }

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            if (min[i] != Integer.MAX_VALUE) {
                ans += min[i];
            }
        }

        if (ans <= k) {
            System.out.println(ans);
        } else {
            System.out.println("Oh no");
        }
    }

    static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static void union(int a, int b) {
        if(a == b) return;
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}
