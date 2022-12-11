package dp.problem2624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] dp = new int[k + 1][t + 1];
        for (int i = 1; i < k + 1; i++) {
            dp[i - 1][0] = 1;

        }
    }
}
