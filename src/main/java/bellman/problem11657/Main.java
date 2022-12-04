package bellman.problem11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static private final int INF = Integer.MAX_VALUE;
    static private int n, m;
    static private int[] distance;
    static private List<int[]> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        boolean isCycle = bf(1);

        if (isCycle) {
            System.out.println("-1");
        }else {
            for (int i = 2; i < n + 1; i++) {
                if (distance[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
        br.close();
    }

    private static boolean bf(int start) {
        distance[start] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur_node = edges.get(j)[0];
                int next_node = edges.get(j)[1];
                int cost = edges.get(j)[2];

                if (distance[cur_node] != INF && distance[next_node] > distance[cur_node] + cost) {
                    distance[next_node] = distance[cur_node] + cost;
                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
