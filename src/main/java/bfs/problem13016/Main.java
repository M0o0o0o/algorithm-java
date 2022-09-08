package bfs.problem13016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] distance;
    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        input();
        visited[1] = true;
        dfs(1);
        System.out.println(Arrays.toString(distance));
    }

    private static void dfs(int start) {
        for (int[] next : graph.get(start)) {
            if(visited[next[0]]) continue;
            visited[next[0]] = true;
            distance[next[0]] = next[1] + distance[start];
            dfs(next[0]);
            visited[next[0]] = false;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, 0);

        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, dis});
            graph.get(to).add(new int[]{from, dis});
        }
        br.close();
    }
}
/**
 *  1 : [0, 3, 7, 13, 16]
 *  2 : [3, 0, 4, 10, 13]
 *  3 : [7, 4, 0, 6, 9]
 *
 */