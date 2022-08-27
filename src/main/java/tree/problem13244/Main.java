package tree.problem13244;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int t, v, e;
    static int[] parent;
    static ArrayList<int[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test = 0; test < t; test++) {
            v = Integer.parseInt(br.readLine());
            e = Integer.parseInt(br.readLine());

            parent = new int[v + 1];
            edges = new ArrayList<>();
            for (int p = 1; p < v + 1; p++) {
                parent[p] = p;
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.add(new int[]{Math.min(a, b), Math.max(a, b)});
            }
            edges.sort((v1, v2) -> {
                if (v1[0] == v2[0])
                    return v1[1] - v2[1];
                return v1[0] - v2[0];
            });
            boolean cycle = false;
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                if (find_parent(a) == find_parent(b)) {
                    cycle = true;
                }
                union_parent(a, b);
            }
            if (cycle || edges.size() != v - 1) {
                System.out.println("graph");
            }else {
                System.out.println("tree");
            }
            for (int i = 1; i < v + 1; i++) {
                find_parent(i);
            }

        }
        br.close();
    }

    static int find_parent(int x) {
        if (parent[x] != x) {
            parent[x] = find_parent(parent[x]);
        }
        return parent[x];
    }

    static void union_parent(int x, int y) {
        x = find_parent(x);
        y = find_parent(y);
        if(x < y) {
            parent[y] = x;
        }else {
            parent[x] = y;
        }
    }
}
