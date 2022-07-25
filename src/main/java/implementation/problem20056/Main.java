package implementation.problem20056;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n, m, k;
    static int[] same = {0, 2, 4, 6};
    static int[] diff = {1, 3, 5, 7};
    static Shark[][] map;
    static ArrayList<Shark> sharks = new ArrayList<>();
    public static void main(String[] args) {
        input();

        for (int i = 0; i < k; i++) {
            solve();
        }

        int ans = 0;
        for (Shark s : sharks) {
            ans += s.m;
        }

        System.out.println(ans);

    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new Shark[n][n];
        for (int i = 0; i < m; i++) {
            sharks.add(new Shark(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new Shark(i, j, 0, 0, 0);
            }
        }

        sc.close();
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j].init(i, j);
            }
        }

        for (Shark shark : sharks) {
            // 개별 상어 이동 후 map을 반영 // cnt 처리가 중요하다.
            int move = shark.s % n;

            int nx = shark.x + dx[shark.d] * move;
            int ny = shark.y + dy[shark.d] * move;
            if (nx >= n) nx -= n;
            if (ny >= n) ny -= n;
            if (nx < 0) nx += n;
            if (ny < 0) ny += n;
            map[nx][ny].sum(shark.s, shark.m, shark.d);
        }

        sharks.clear();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].cnt == 1) {
                    sharks.add(new Shark(i, j, map[i][j].m, map[i][j].s, map[i][j].d));
                } else if (map[i][j].cnt > 1) {
                    map[i][j].s /= map[i][j].cnt;
                    map[i][j].m /= 5;
                    if(map[i][j].m == 0) continue;
                    int[] dir = null;
                    if (map[i][j].even == map[i][j].cnt || map[i][j].odd == map[i][j].cnt) {
                        dir = same;
                    } else {
                        dir = diff;
                    }

                    for (int d : dir) {
                        sharks.add(new Shark(map[i][j].x, map[i][j].y, map[i][j].m, map[i][j].s, d));
                    }

                }
            }
        }
    }
}

class Shark {
    int x,y,m,s, d, cnt;
    int odd, even;
    public Shark(int x, int y, int m, int s, int d) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.s = s;
        this.d = d;
    }

    public void sum(int s, int m, int d) {
        this.cnt++;
        this.s += s;
        this.m += m;
        if(d % 2 == 0) this.even++;
        else this.odd++;
        this.d = d;

    }

    public void init(int x, int y) {
        this.x = x;
        this.y = y;
        this.m = 0;
        this.s = 0;
        this.d = 0;
        this.cnt = 0;
        this.odd = 0;
        this.even = 0;
    }

}

