package programmers.lessons132266;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        boolean[][] board = new boolean[n + 1][n + 1];
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        for (int[] road : roads) {
            board[road[0]][road[1]] = true;
            board[road[1]][road[0]] = true;
        }


        bfs(board, visited, destination, n);

        return Arrays.stream(sources).map(source -> {
            if (visited[source] == Integer.MAX_VALUE) {
                return -1;
            } else {
                return visited[source];
            }
        }).toArray();
    }

    private void bfs(boolean[][] board, int[] visited, int destination, int n) {
        Queue<Integer> q = new LinkedList<>();
        visited[destination] = 0;
        q.add(destination);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i < n + 1; i++) {
                if (board[now][i] && visited[i] > visited[now] + 1) {
                    visited[i] = visited[now] + 1;
                    q.add(i);
                }
            }
        }
    }

    @Test
    public void test() {
        int[] solution = solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1);
        System.out.println(Arrays.toString(solution));

    }
}