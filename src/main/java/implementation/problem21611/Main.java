package implementation.problem21611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, sx, sy;
    static int[] dx = {0,-1, 1, 0, 0};
    static int[] dy = {0,0, 0, -1, 1};
    static int[] destroy = new int[4];
    static int[][] board;
    static ArrayList<int[]> order = new ArrayList<>();
    static Queue<Integer> zero = new LinkedList<>();
    static Queue<Integer> newNum = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sx = n / 2;
        sy = n / 2;
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeOrder();

        while (m > 0) {
            m--;
            st = new StringTokenizer(br.readLine());
            magic(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            move();
            while (boom()) {
                move();
            }
            change();
        }

        System.out.println(destroy[1] + (destroy[2] * 2) + (destroy[3]) * 3);

        br.close();
    }

    public static void magic(int d, int s) {
        int x = sx;
        int y = sy;
        for (int i = 0; i < s; i++) {
            x += dx[d];
            y += dy[d];
            if(0 > x || x >= n || 0 > y || y >= n || board[x][y] == 0) break;
            board[x][y] = 0;
        }
    }

    public static void move() {
        for (int i = 0; i < order.size(); i++) {
            int[] now = order.get(i);
            int x = now[0];
            int y = now[1];

            if (board[x][y] == 0) {
                zero.add(i);
                continue;
            }

            if (!zero.isEmpty()) {
                zero.add(i);
                int[] zIdx = order.get(zero.poll());
                board[zIdx[0]][zIdx[1]] = board[x][y];
                board[x][y] = 0;
            }
        }
        zero.clear();
    }


    public static boolean boom() {
        int cnt = 1;
        int color = board[order.get(0)[0]][order.get(0)[1]];
        boolean isBoom = false;
        for (int i = 1; i < order.size() + 1; i++) {
            int[] now = null;
            if (i < order.size()) {
                now = order.get(i);
                if (i < order.size() && board[now[0]][now[1]] == color) {
                    cnt++;
                    continue;
                }
            }
            if(color == 0) return false;
            if (cnt >= 4) {
                destroy[color] += cnt;

                isBoom = true;
                for (int j = i - cnt; j < i; j++) {
                    int[] remove = order.get(j);
                    board[remove[0]][remove[1]] = 0;
                }
            }

            if (i == order.size()) return isBoom;
            if(board[now[0]][now[1]] == 0) return isBoom;
            cnt = 1;
            color = board[now[0]][now[1]];
        }

        return isBoom;
    }
    public static void change() {
        // 구슬 개수, 구슬 번호
        int cnt = 1;
        int color = board[order.get(0)[0]][order.get(0)[1]];
        if(color == 0) return;
        for (int i = 1; i < order.size(); i++) {
            int[] now = order.get(i);
            int x = now[0];
            int y = now[1];
            if (board[x][y] == color) {
                cnt++;
                continue;
            }
            if(newNum.size() >= order.size()) break;
            newNum.add(cnt);
            newNum.add(color);
            if(board[x][y] == 0) break;
            cnt = 1;
            color = board[x][y];
        }

        for (int i = 0; i < order.size(); i++) {
            if(newNum.isEmpty()) break;
            int[] now = order.get(i);
            int x = now[0];
            int y = now[1];
            board[x][y] = newNum.poll();
        }
        newNum.clear();
    }

    public static void makeOrder() {
        int[] ddx = {0, 1, 0, -1};
        int[] ddy = {-1, 0, 1, 0};
        int x = n / 2;
        int y = n / 2;
        int limit = 2;
        int cnt = 0;
        int d = 0;
        while (!(x == 0 && y == 0)) {
            x += ddx[d];
            y += ddy[d];
            order.add(new int[]{x, y});
            cnt++;
            if (cnt * 2 == limit || cnt == limit) d = (d + 1) % 4;
            if (cnt == limit) {
                cnt = 0;
                limit += 2;
            }
        }

    }
}
