package bfs.problem2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    static int n, m;
    static Queue<int[]> queue;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        // ======
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.valueOf(s.charAt(j) - '0');
            }
        }
    // ======

        System.out.println(bfs() + 1);

        br.close();
    }

    private static int bfs() {
        queue = new LinkedList<>();
        // 오른쪽, 아래, 왼쪽, 위
        int[] dx = new int[]{0, 1, 0, -1}; // 행
        int[] dy = new int[]{1, 0, -1, 0}; // 열
        queue.add(new int[]{0, 0, 0}); // 행, 열, 지나온 칸의 개수

        visited[0][0] = true;
        // N: 4 M: 6
        // 3, 5 배열은 0인덱스부터 시작하니까
        int[] array = new int[5];
        while (queue.size() > 0) {
            int[] now = queue.poll();

            if (now[0] == n - 1 && now[1] == m - 1) { // 도착지에 도달한 경우
                return now[2];
            }
            // 0, 1, 2, 3
            for (int i = 0; i < 4; i++) {
                int nextRow = now[0] + dx[i];
                int nextCol = now[1] + dy[i];
                // 0 <= nextRow < n  , 0 <= nextCol < m
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && board[nextRow][nextCol] == 1) {
                    if(visited[nextRow][nextCol]) continue;
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol, now[2] + 1});
                }

            }
        }
        return -1;
    }
}
