package programmers.season1.lessons86971;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int n, int[][] wires) {
        int ans = Integer.MAX_VALUE;
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] wire : wires) {
            int from = wire[0], to = wire[1];
            graph[from][to] = true;
            graph[to][from] = true;
        }

        for (int[] wire : wires) {
            int result = bfs(n, wire, graph);
            int rest = Math.abs(n - result);
            ans = Math.min(ans, Math.abs(result - rest));

        }
        return ans;
    }

    private int bfs(int n, int[] wire, boolean[][] graph) {
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next = 1; next < n + 1; next++) {
                if (visited[next] || (now == wire[0] && next == wire[1]) || (now == wire[1] && next == wire[0]) || !graph[now][next]) {
                    continue;
                }

                cnt++;
                visited[next] = true;
                q.add(next);
            }
        }
        return cnt;
    }


//    @Test
//    void test() {
//        int solution = solution(9,
//                new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
//
//        System.out.println(solution);
//
//    }
}