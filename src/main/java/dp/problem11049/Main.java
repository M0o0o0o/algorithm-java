package dp.problem11049;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11049
public class Main {
    static int n;
    static int[][] mat;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        mat = new int[n][2];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            mat[i][0] = sc.nextInt();
            mat[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = mat[i][0] * mat[i][1] * mat[i + 1][1];
        }

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (mat[i][0] * mat[k][1] * mat[j][1]));
                    System.out.println(i + " " + k  + " " + j);
                }
            }
        }
        System.out.println("=====");
        System.out.println("=====");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=====");

        System.out.println(dp[0][n - 1]);
        sc.close();
    }
}

/*
4
5 3
3 2
2 6
6 3

8
1 100
100 1
1 100
100 1
1 100
100 1
1 100
100 1
 */