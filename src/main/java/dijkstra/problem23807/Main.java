package dijkstra.problem23807;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, p, s, e;
    static final long INF = 999876454321L;
    static long ans;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static HashMap<Integer, long[]> distance = new HashMap<>();
    static int[] plist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = INF;

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
        p = Integer.parseInt(br.readLine());
        plist = new int[p];
        st = new StringTokenizer(br.readLine());

        distance.put(s, new long[n + 1]);
        for (int i = 0; i < p; i++) {
            int mid = Integer.parseInt(st.nextToken());
            plist[i] = mid;
            distance.put(mid, new long[n + 1]);
        }


        for (Integer mid : distance.keySet()) {
            dijkstra(mid, distance.get(mid));
        }


        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < p; k++) {
                    if(i == j || i == k || j == k) continue;
                    ans = Math.min(ans, calc(plist[i], plist[j], plist[k]));
                }
            }
        }

        if(ans == INF) System.out.println(-1);
        else System.out.println(ans);

        br.close();
    }

    static void dijkstra(int start, long[] distance) {
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
                if (cost < distance[edge.next]) {
                    distance[edge.next] = cost;
                    q.add(new long[]{edge.next, cost});
                }
            }
        }
    }

    static class Edge {
        int next;
        long cost;
        public Edge(int next, long cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static long calc(int a, int b, int c) {
        return distance.get(s)[a] + distance.get(a)[b] + distance.get(b)[c] + distance.get(c)[e];
    }
}



