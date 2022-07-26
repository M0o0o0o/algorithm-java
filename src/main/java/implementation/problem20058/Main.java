package implementation.problem20058;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n , q;
    static int[][] board;
    static int[][] buf;
    static int[][] rotate;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int total = 0  , maxCnt = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = (int) Math.pow(2, sc.nextInt());
        q = sc.nextInt();
        board = new int[n][n];
        buf = new int[n][n];
        rotate = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        while (q > 0) {
            q--;
            int r = (int) Math.pow(2, sc.nextInt());

            for (int i = 0; i < n; i += r) {
                for (int j = 0; j < n; j += r) {
                    rotate(i, j, r);
                }
            }
            minus();
        }


        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] > 0) {
                    bfs(visited, i, j);
                }
            }
        }

        System.out.println(total);
        System.out.println(maxCnt != -1 ? maxCnt : 0);

        sc.close();
    }

    private static void bfs(boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        total += board[x][y];
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] > 0 && !visited[nx][ny]) {
                    cnt++;
                    total += board[nx][ny];
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        if (cnt > maxCnt) {
            maxCnt = cnt;
        }
    }

    private static void minus() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buf[i][j] = 0;
                int cnt = 0;
                if(board[i][j] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] > 0) cnt += 1;
                }
                buf[i][j] = cnt < 3 ? -1 :0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] += buf[i][j];
            }
        }

        return;
    }

    private static void rotate(int x, int y, int r) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                buf[i][j] = board[x + i][y + j];
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                rotate[i][j] = buf[r - 1 - j][i];
                board[i + x][j + y] = rotate[i][j];
            }
        }
        return;
    }
}
