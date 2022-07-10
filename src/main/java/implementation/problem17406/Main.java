package implementation.problem17406;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/17406
public class Main {
    static int n,m, k;
    static int[][] board;
    static int[][] buf;
    static int ans = Integer.MAX_VALUE;
    static LinkedList<int[]> list = new LinkedList<>();
    static boolean[] visited;
    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        board = new int[n][m];
        buf = new int[n][m];
        visited = new boolean[k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                buf[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(new int[]{sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()});
        }

        dfs(0,new LinkedList<int[]>());
        System.out.println(ans);
        sc.close();

    }

    private static void dfs(int cnt, LinkedList<int[]> order) {
        if (cnt == list.size()) {
            rotate(order);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                order.add(list.get(i));
                dfs(cnt + 1, order);
                visited[i] = false;
                order.pollLast();
            }
        }
    }

    private static void rotate(LinkedList<int[]> order) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                buf[i][j] = board[i][j];
            }
        }

        for (int[] o : order) {
            int sx = o[0] - o[2];
            int sy = o[1] - o[2];
            int ex = o[0] + o[2];
            int ey = o[1] + o[2];
            int x = sx;
            int y = sy;
            int d = 0;
            int value = 0;
            while (true) {
                if (d == 3 && x == sx && y == sy) {
                    sx++; sy++; ex--; ey--;
                    x = sx;
                    y = sy;
                    d = 0;
                    value = 0;
                    if(x == o[0] && y == o[1]) break;
                }
                int nx = x + DX[d];
                int ny = y + DY[d];
                if (nx < sx || nx > ex || ny < sy || ny > ey) {
                    d++;
                    continue;
                }
                if (value == 0) {
                    value = buf[nx][ny];
                    buf[nx][ny] = buf[x][y];
                } else {
                    int bufValue = buf[nx][ny];
                    buf[nx][ny] = value;
                    value = bufValue;
                }
                x = nx;
                y = ny;
            }
        }

        cal();
    }

    private static void cal() {
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += buf[i][j];
            }
            ans = Math.min(ans, rowSum);
        }
    }

}
