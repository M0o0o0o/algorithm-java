package implementation.problem14719;

//https://www.acmicpc.net/problem/14719

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int r, c;
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        int ans = 0;
        board = new int[r][c];
        for (int i = 0; i < c; i++) {
            int now = sc.nextInt();
            int idx = r - 1;
            while (now > 0) {
                board[idx--][i] = 1;
                now--;
            }
        }
        for (int i = r - 1; i >= 0; i--) {
            boolean left = false;
            int cnt = 0;
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 0) {
                    cnt++;
                } else {
                    if (!left) {
                        left = true;
                    } else {
                        ans += cnt;
                    }
                    cnt = 0;
                }
            }

        }
        System.out.println(ans);

        sc.close();
    }

}
