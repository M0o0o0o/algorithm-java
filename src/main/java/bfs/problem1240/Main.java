package bfs.problem1240;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        LinkedList<LinkedList<int[]>> graph = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, diff});
            graph.get(to).add(new int[]{from, diff});
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            System.out.println(bfs(graph, from, to));
        }


        br.close();
    }

    private static int bfs(LinkedList<LinkedList<int[]>> graph, int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;


        while (!q.isEmpty()) {
            int now = q.poll();

            for (int[] next : graph.get(now)) {
                if (visited[next[0]] > visited[now] + next[1]) {
                    q.add(next[0]);
                    visited[next[0]] = visited[now] + next[1];
                }
            }
        }

        return visited[end];
    }
}
