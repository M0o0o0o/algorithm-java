package implementation.problem23289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/23289
public class Main {
    static int n, m, k, ans, w;
    static int[][] board, buf;
    static boolean[][] horizon, verticle;
    static int[][] dx = {{-1, -1, -1}, {-1, 0, 1}, {-1, 0, 1}, {-1, -1, -1}, {1, 1, 1}};
    static int[][] dy = {{-1, -1, -1}, {1, 1, 1}, {-1, -1, -1}, {-1, 0, 1}, {-1, 0, 1}};
    static ArrayList<int[]> fan = new ArrayList<>();
    static ArrayList<int[]> check = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        horizon = new boolean[n][m];
        verticle = new boolean[n][m];
        buf = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] >= 1 && board[i][j] <= 4) {
                    fan.add(new int[]{i, j, board[i][j]});
                    board[i][j] = 0;
                }

                if (board[i][j] == 5) {
                    check.add(new int[]{i, j});
                    board[i][j] = 0;
                }
            }
        }
        w = Integer.parseInt(br.readLine());
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());
            if (t == 0) {
                horizon[r][c] = true;
            } else {
                verticle[r][c] = true;
            }
        }
        solve();
        System.out.println(ans > 100 ? 101 :ans);
        br.close();
    }

    private static void solve() {
        while (!isFinish()) {
            ans++;
            if(ans > 100) break;
            for (int[] f : fan) {
                fanWorking(f);
            }
            divide();
            minusOne();
        }
    }

    private static void fanWorking(int[] f) {
        q.clear();
        visited = new boolean[n][m];
        int[] fx = dx[f[2]];
        int[] fy = dy[f[2]];
        int x = f[0] + fx[1];
        int y = f[1] + fy[1];

        visited[x][y] = true;
        board[x][y] += 5;
        q.add(new int[]{x, y, 4});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx = now[0] + fx[i];
                int ny = now[1] + fy[i];
                if (0 > nx || nx >= n || 0 > ny || ny >= m || visited[nx][ny]) continue;
                if (!isMove(now[0], now[1], nx, ny, f[2], i)) continue;
                board[nx][ny] += now[2];
                visited[nx][ny] = true;
                if (now[2] == 1) continue;
                q.add(new int[]{nx, ny, now[2] - 1});
            }
        }
    }

    public static boolean isMove(int x, int y, int nx, int ny, int d, int o) {
        if (o == 1) {
            if (d == 1 && verticle[x][y]) return false;
            else if (d == 2 && verticle[nx][ny]) return false;
            else if (d == 3 && horizon[x][y]) return false;
            else if (d == 4 && horizon[nx][ny]) return false;
        } else if (o == 0) {
            if (d == 1 && (horizon[x][y] || verticle[nx][y])) return false;
            else if (d == 2 && (horizon[x][y] || verticle[nx][ny])) return false;
            else if (d == 3 && (verticle[x][ny] || horizon[x][ny])) return false;
            else if (d == 4 && (verticle[x][ny] || horizon[nx][ny])) return false;
        } else {
            if (d == 1 && (horizon[nx][y] || verticle[nx][y])) return false;
            else if (d == 2 && (verticle[nx][ny] || horizon[nx][y])) return false;
            else if (d == 3 && (verticle[x][y] || horizon[x][ny])) return false;
            else if (d == 4 && (verticle[x][y] || horizon[nx][ny])) return false;
        }
        return true;
    }

    private static void divide() {
        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                buf[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 1; d <= 4; d++) {
                    int x = i + dx[d];
                    int y = j + dy[d];
                    if (0 > x || x >= n || 0 > y || y >= m) continue;
                    if (board[i][j] <= board[x][y]) continue;
                    if (d == 1 && verticle[i][j]) continue;
                    if (d == 2 && verticle[x][y]) continue;
                    if (d == 3 && horizon[i][j]) continue;
                    if (d == 4 && horizon[x][y]) continue;

                    int diff = (board[i][j] - board[x][y]) / 4;
                    buf[i][j] -= diff;
                    buf[x][y] += diff;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += buf[i][j];
                if (board[i][j] < 0) board[i][j] = 0;
            }
        }
    }

    private static void minusOne() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] >= 1 && (i == 0 || i == n - 1 || j == 0 || j == m - 1)) board[i][j] -= 1;
            }
        }
    }

    private static boolean isFinish() {
        for (int[] c : check) {
            if (board[c[0]][c[1]] < k) return false;
        }
        return true;
    }
}
