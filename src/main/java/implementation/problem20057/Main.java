package implementation.problem20057;

import java.util.Scanner;

public class Main {
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // 1% 1% 7% 7% 2% 2% 10% 10% 5% a
    static int[][] mx = {{-1, 1, -1, 1, -2, 2, -1, 1, 0, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1}, {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2, -1}}; // 왼쪽, 아래, 오른쪽, 위
    static int[][] my = {{1, 1, 0, 0, 0, 0, -1, -1, -2, -1}, {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1}, {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0}};
    static double[] percent = {0.01, 0.01, 0.07, 0.07, 0.02, 0.02, 0.1, 0.1, 0.05, -1};
    static int[][] board;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int x = n / 2;
        int y = n / 2;
        int d = 0;
        int cnt = 0;
        int limit = 2;
        while (true) {
            x += dx[d];
            y += dy[d];
            solve(x, y, d);

            cnt++;
            if (cnt * 2 == limit || limit == cnt) d++;
            if (limit == cnt) {
                limit += 2;
                cnt = 0;
            }
            if(d==4) d = 0;


            if(x == 0 && y == 0) break;
        }

        System.out.println(ans);

    }

    private static void solve(int x, int y, int d) {
        if(board[x][y] ==0) return;

        int[] ddx = mx[d];
        int[] ddy = my[d];
        int moveSend = 0;
        for (int i = 0; i < ddx.length-1; i++) {
            int nx = x + ddx[i];
            int ny = y + ddy[i];
            int num = (int) (board[x][y] * percent[i]);
            moveSend += num;

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                board[nx][ny] += num;
            } else {
                ans += num;
            }
        }
        int nx = ddx[ddx.length - 1] + x;
        int ny = ddy[ddx.length - 1] + y;
        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
            board[nx][ny] += board[x][y] - moveSend;
        } else {
            ans += board[x][y] - moveSend;
        }

        board[x][y] = 0;
        return;
    }
}
