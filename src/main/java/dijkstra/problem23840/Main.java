package dijkstra.problem23840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, s, e, p;
    static final long INF = 999876454321L;
    static int fullBit;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] plist;
    static long[][] distance, dp;

    public static void main(String[] args) throws IOException {
        input();
        fullBit = (1 << p) - 1;
        dp = new long[p][fullBit];
        for (int i = 0; i < p; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < p; i++) {
            dijkstra(plist[i], distance[i]);
        }

        long ans = tsp(0, 1);
        if(ans == INF) System.out.println(-1);
        else System.out.println(ans);

    }

    private static long tsp(int x, int check) {

        if (check == fullBit) {
            if(distance[x][e] == INF) return INF;
            return distance[x][e];
        }

        if(dp[x][check] != -1) return dp[x][check];

        dp[x][check] = INF;

        for (int i = 0; i < p; i++) {
            int next = check | (1 << i);

            if(distance[x][plist[i]] == INF || (check & (1<<i)) != 0) continue;

            dp[x][check] = Math.min(dp[x][check], tsp(i, next) + distance[x][plist[i]]);
        }

        return dp[x][check];
    }

    private static void dijkstra(int start, long[] distance) {
        for (int i = 0; i < n + 1; i++) {
            distance[i] = INF;
        }
        distance[start] = 0;
        PriorityQueue<long[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else if (o1[1] < o2[1]) return -1;
            else return 0;
        });
        q.add(new long[]{start, 0});

        while (!q.isEmpty()) {
            long[] now = q.poll();
            int node = (int) now[0];
            long dist = now[1];
            if(distance[node] < dist) continue;
            for (Edge edge : graph.get(node)) {
                long cost = dist + edge.cost;
                if (cost < distance[edge.node]) {
                    distance[edge.node] = cost;
                    q.add(new long[]{edge.node, cost});
                }
            }
        }

    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(br.readLine()) + 1;
        plist = new int[p];
        plist[0] = s;
        distance = new long[p][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < p; i++) {
            plist[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        return;
    }


    static class Edge {
        int node;
        long cost;

        public Edge(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}

