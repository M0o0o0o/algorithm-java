package implementation.problem2615;

import java.util.Scanner;

public class Main {
    static int n = 19;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {1, 1, 1, 0};
    static int[] dy = {-1, 1, 0, 1};
    static int ansType, ansX, ansY;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[n][n];
        visited = new boolean[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    if (!visited[i][j][d]) {
                        if (solve(i, j, d)) {
                            System.out.println(ansType);
                            System.out.println((ansX+1) + " " + (ansY+1));
                            System.exit(0);
                        }
                    }
                }
            }
        }

        System.out.println(0);

    }

    public static boolean solve(int x, int y, int d) {
        int cnt = 1;
        int type = board[x][y];
        int startX = x, startY = y;
        visited[x][y][d] = true;
        while (true) {
            x += dx[d];
            y += dy[d];
            if(0 > x || x >= n || 0 > y || y >= n || type != board[x][y] || visited[x][y][d]) break;
            cnt++;
            visited[x][y][d] = true;
        }
        if(cnt != 5) return false;
        if (d == 0) {
            ansX = x - dx[d];
            ansY = y - dy[d];
        } else {
            ansX = startX;
            ansY = startY;
        }
        ansType = type;
        return true;
    }
}
