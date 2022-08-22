package dfs.problem25195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, k;
    private static HashSet<Integer> fans = new HashSet<>();
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            fans.add(Integer.parseInt(st.nextToken()));
        }

        visited[1] = true;
        if (fans.contains(1)) {
            System.out.println("Yes");
        }else {
            dfs(1);
            System.out.println("Yes");
        }

        br.close();
    }

    private static void dfs(int now) {
        if (graph.get(now).size() == 0) {
            System.out.println("yes");
            System.exit(0);
        }

        for (int next : graph.get(now)) {
            if (!visited[next] && !fans.contains(next)) {
                visited[next] = true;
                dfs(next);
                visited[next] = false;
            }

        }
    }
}
