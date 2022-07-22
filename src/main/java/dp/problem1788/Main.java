package dp.problem1788;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] dp;
    static int mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n>0) System.out.println(1);
        else if (n < 0) {
            n = -n;
            if(n%2 == 0) System.out.println(-1);
            else System.out.println(1);
        } else System.out.println(0);

        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(solve(n));
    }

    static int solve(int x) {
        if(x == 0) return 0;
        if(x == 1 || x == 2) return 1;
        if(dp[x] != -1) return dp[x];
        return dp[x] = (solve(x - 1) % mod + solve(x - 2) % mod) % mod;
    }
}
