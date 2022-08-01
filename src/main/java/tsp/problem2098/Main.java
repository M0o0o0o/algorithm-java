package tsp.problem2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, statusFull, INF = 987654321;
    static int[][] w, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        statusFull = (1 << n) - 1;
        w = new int[n][n];
        dp = new int[n][statusFull];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

    }

    static int tsp(int x, int check) {
        if (check == statusFull) {
            if(w[x][0] == 0) return INF;
            else return w[x][0];
        } // 모든 도시 방문 완료

        if(dp[x][check] != -1) return dp[x][check]; // 이미 방문한 도시

        dp[x][check] = INF; // 해당 도시에 출석

        for (int i = 0; i < n; i++) {
            int next = check | (1 << i);
            if(w[x][i] == 0 || (check & (1 << i)) != 0) continue;

            dp[x][check] = Math.min(dp[x][check], tsp(i, next) + w[x][i]);
        }

        return dp[x][check];
    }
}
