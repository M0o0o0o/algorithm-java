package bfs.problem25417;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n = 5;
    static int[][] board = new int[n][n];
    static int[][] visited = new int[n][n];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int INF = Integer.MAX_VALUE;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ex = -1;
        int ey = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = INF;
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    ex = i;
                    ey = j;
                }
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        visited[x][y] = 0;
        q.add(new int[]{x, y});
        bfs();
        System.out.println(visited[ex][ey] == INF ? -1 : visited[ex][ey]);

    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            run(now);
            walk(now);
        }
    }

    private static void walk(int[] now) {
        for (int i = 0; i < 4; i++) {
            int x = now[0] + dx[i];
            int y = now[1] + dy[i];
            if (x >= 0 && x < n && y >= 0 && y < n && visited[x][y] > visited[now[0]][now[1]] + 1 && board[x][y] != -1) {
                visited[x][y] = visited[now[0]][now[1]] + 1;
                q.add(new int[]{x, y});
            }
        }
    }

    private static void run(int[] now) {
        for (int i = 0; i < 4; i++) {
            int x = now[0];
            int y = now[1];
            while (true) {
                x += dx[i];
                y += dy[i];
                if (x < 0 || x >= n || y < 0 || y >= n || board[x][y] == -1) {
                    x -= dx[i];
                    y -= dy[i];
                    if (visited[x][y] > visited[now[0]][now[1]] + 1) {
                        q.add(new int[]{x, y});
                        visited[x][y] = visited[now[0]][now[1]] + 1;
                    }
                    break;
                }

                if (board[x][y] == 7 && visited[x][y] > visited[now[0]][now[1]] + 1) {
                    q.add(new int[]{x, y});
                    visited[x][y] = visited[now[0]][now[1]] + 1;
                    break;
                 }
            }
        }

    }

}
