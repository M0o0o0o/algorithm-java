package implementation.problem21610;

import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    //                    ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx2 = {-1, -1, 1, 1};
    static int[] dy2 = {-1, 1, 1, -1};
    static Queue<int[]> cloud = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        cloud.add(new int[]{n - 1, 0});
        cloud.add(new int[]{n - 2, 0});
        cloud.add(new int[]{n - 1, 1});
        cloud.add(new int[]{n - 2, 1});

        while (m > 0) {
            m--;
            int d = sc.nextInt();
            int s = sc.nextInt();
            move(d, s);
            magic();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += board[i][j];
            }
        }

        System.out.println(ans);

        sc.close();
    }


    public static void move(int d, int s) {

        for (int[] now : cloud) {
            int x = (n + now[0] + dx[d] * (s % n)) % n;
            int y = (n + now[1] + dy[d] * (s % n)) % n;
            board[x][y] += 1;
            visited[x][y] = true;
            now[0] = x;
            now[1] = y;
        }

        while (!cloud.isEmpty()) {
            int[] now = cloud.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx2[i];
                int ny = now[1] + dy2[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] > 0) {
                    board[now[0]][now[1]]++;
                }
            }
        }
    }

    public static void magic() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] >= 2) {
                    cloud.add(new int[]{i, j});
                    board[i][j] -= 2;
                }
            }
        }
        visited = new boolean[n][n];
    }

}
