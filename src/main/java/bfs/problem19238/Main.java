package bfs.problem19238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m, fuel, tx, ty;
    static int[][] board;
    static int[][] distance;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static List<int[]> customers = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(fuel);
    }

    private static void solve() {
        while (!customers.isEmpty()) {
            int customerIdx = -1;
            int minDistance = Integer.MAX_VALUE;

            bfs();

            for (int i = 0; i < customers.size(); i++) {
                int[] c = customers.get(i);
                if (minDistance > Math.abs(distance[tx][ty] - distance[c[0]][c[1]])) {
                    minDistance = Math.abs(distance[tx][ty] - distance[c[0]][c[1]]);
                    customerIdx = i;
                }
            }

            if (customerIdx == -1) {
                fuel = -1;
                break;
            }

            int[] c = customers.remove(customerIdx);
            int taxiToCustomer = Math.abs(distance[tx][ty] - distance[c[0]][c[1]]);
            int customerToEnd = getDist(c[0], c[1], c[2], c[3]);
            if (fuel < taxiToCustomer + customerToEnd || taxiToCustomer == -1 || customerToEnd == -1) {
                fuel = -1;
                break;
            }

            fuel = fuel - taxiToCustomer - customerToEnd + (customerToEnd * 2);

            tx = c[2];
            ty = c[3];
        }
        return;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        st = new StringTokenizer(br.readLine());
        tx = Integer.parseInt(st.nextToken()) - 1;
        ty = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            customers.add(new int[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1});
        }

        customers.sort((o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        br.close();
    }

    private static void bfs() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{tx, ty});
        distance[tx][ty] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 0 && distance[now[0]][now[1]] + 1 < distance[x][y]) {

                    queue.add(new int[]{x, y});
                    distance[x][y] = distance[now[0]][now[1]] + 1;
                }
            }
        }
        return;
    }

    private static int getDist(int sx, int sy, int ex, int ey) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        distance[sx][sy] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 0 && distance[now[0]][now[1]] + 1 < distance[x][y]) {
                    queue.add(new int[]{x, y});
                    distance[x][y] = distance[now[0]][now[1]] + 1;
                    if (x == ex && y == ey) {
                        return distance[x][y];
                    }
                }
            }
        }
        return -1;
    }
}
