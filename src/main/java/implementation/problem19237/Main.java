package implementation.problem19237;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N, M, k;
    static int[][] rest;
    static int[][] smell;
    static int[][][] dir;
    static Shark[] shark;
    static int[] dx = { 0, -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        rest = new int[N + 1][N + 1];
        smell = new int[N + 1][N + 1];
        dir = new int[M + 1][5][4];
        shark = new Shark[M + 1];

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(input[j - 1]);

                if (n > 0) {
                    shark[n] = new Shark(i, j, 0);
                    rest[i][j] = k;
                    smell[i][j] = n;
                }
            }
        }
        input = br.readLine().split(" ");
        for (int i = 1; i <= M; i++)
            shark[i].d = Integer.parseInt(input[i - 1]);

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= 4; j++) {
                input = br.readLine().split(" ");
                for (int k = 0; k < 4; k++) {
                    dir[i][j][k] = Integer.parseInt(input[k]);
                }
            }
        }

        bw.write(solve() + "\n");
        bw.flush();

    }

    public static int solve() {

        int time = 0;

        while (true) {

            int count = 0;
            for (int m = 1; m <= M; m++) {
                if (shark[m] != null)
                    count++;
            }

            if (count == 1 && shark[1] != null) {
                return time;
            }

            if (time >= 1000)
                return -1;

            int[][] tmp = new int[N + 1][N + 1];

            for (int m = 1; m <= M; m++) {

                if (shark[m] != null) {
                    moveShark(tmp, m);
                }
            }


            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (rest[i][j] > 0)
                        rest[i][j]--;

                    if (rest[i][j] == 0)
                        smell[i][j] = 0;
                }
            }


            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (tmp[i][j] > 0) {
                        rest[i][j] = k;
                        smell[i][j] = tmp[i][j];
                    }
                }
            }
            time++;
        }

    }

    public static void moveShark(int[][] tmp, int m) {

        int nr = 0;
        int nc = 0;
        int d = 0;

        boolean flag = false;


        for (int i = 0; i < 4; i++) {

            d = dir[m][shark[m].d][i];
            nr = shark[m].r + dx[d];
            nc = shark[m].c + dy[d];


            if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == 0) {
                flag = true;
                break;
            }
        }


        if (!flag) {
            for (int i = 0; i < 4; i++) {

                d = dir[m][shark[m].d][i];
                nr = shark[m].r + dx[d];
                nc = shark[m].c + dy[d];

                if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == m)
                    break;
            }
        }

        if (tmp[nr][nc] == 0) {

            tmp[nr][nc] = m;
            shark[m].r = nr;
            shark[m].c = nc;
            shark[m].d = d;
        }

        else {
            shark[m] = null;
        }

    }

    static class Shark {

        int r, c, d;

        Shark(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

}