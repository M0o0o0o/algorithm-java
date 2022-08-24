package bfs.problem16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 주사위에는 1 ~ 6
 * 게임은 10 x 10 총 100칸
 * 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다.
 */
public class Main {
    static int n, m;
    static HashMap<Integer, Integer> info = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            info.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(bfs());
        br.close();

    }

    private static int bfs() {
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        visited[1] = true;

        queue.add(new int[]{1, 0});

        while (!queue.isEmpty()) {
            // now[0]: location, now[1] : cnt
            int[] now = queue.poll();
            if (now[0] == 100) {
                ans = now[1];
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now[0] + i;
                if (next > 100 || visited[next]) {
                    continue;
                }

                if (info.containsKey(next)) {
                    next = info.get(next);
                }

                visited[next] = true;
                queue.add(new int[]{next, now[1] + 1});
            }
        }
        return ans;
    }
}
