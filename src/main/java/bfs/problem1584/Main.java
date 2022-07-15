package bfs.problem1584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n = 501;
    static int[][] board = new int[n][n];
    static int[][] visited = new int[n][n];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        init(1, br);
        init(2, br);
        bfs();

        if(visited[n-1][n-1] != Integer.MAX_VALUE)
            System.out.println(visited[n - 1][n - 1]);
        else System.out.println(-1);

        br.close();

    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = 0;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && board[nx][ny] != 2) {

                    if (visited[nx][ny] > visited[x][y] + board[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[x][y] + board[nx][ny];
                    }
                }
            }
        }


    }

    private static void init(int num, BufferedReader br) throws IOException {
        int d = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                    board[j][k] = num;
                }
            }
        }

    }


}
