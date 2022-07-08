package implementation.problem2740;

import java.util.Scanner;

public class Main {
    static int n, m, k;
    static int[][] a,b, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        m = sc.nextInt();
        k = sc.nextInt();
        b = new int[m][k];
        ans = new int[n][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        for (int aRow = 0; aRow < n; aRow++) {
            for (int bCol = 0; bCol < k; bCol++) {
                int cal = 0;
                for (int bRow = 0; bRow < m; bRow++) {
                    cal += (a[aRow][bRow] * b[bRow][bCol]);
                }
                ans[aRow][bCol] = cal;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

}
