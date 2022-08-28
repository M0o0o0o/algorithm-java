package tree.problem1405;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1405
public class Main {
    static int n;
    static double[] percent;
    static double ans;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    public static void main(String[] args) {
        input();
        visited[15][15] = true;
        dfs(15, 15, 0, 1);
        System.out.println(ans);

    }

    private static void dfs(int x, int y, int cnt, double percents) {
        if (cnt == n) {
            ans += percents;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 30 && ny >= 0 && ny < 30) {
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1, percents * percent[i]);
                visited[nx][ny] = false;
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        percent = new double[4];
        for (int i = 0; i < 4; i++) {
            percent[i] = sc.nextInt() * 0.01;
        }

        visited = new boolean[30][30];

        sc.close();
    }
}
