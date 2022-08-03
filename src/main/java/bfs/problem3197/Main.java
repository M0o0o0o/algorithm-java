package bfs.problem3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] board;
    static Queue<int[]> sq = new LinkedList<>();
    static Queue<int[]> wq = new LinkedList<>();
    static boolean[][] sv, wv;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        input();
        wallInit();
        if (swanBfs()) {
            System.out.println(ans);
            return;
        }

        while (true) {
            wallBfs();
            ans++;
            if(swanBfs()) break;
        }
        System.out.println(ans);
        return;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        sv = new boolean[n][m];
        wv = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'L' && sq.isEmpty()) {
                    board[i][j] = '.';
                    sq.add(new int[]{i, j});
                    sv[i][j] = true;
                }
            }
        }
        br.close();
    }

    private static boolean swanBfs() {
        while (!sq.isEmpty()) {
            int[] now = sq.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (!sv[x][y] && board[x][y] == '.') {
                        sv[x][y] = true;
                        sq.add(new int[]{x, y});
                    }
                    if(board[x][y] == 'L'){return true;}
                }
            }
        }
        changeWq();
        return false;
    }

    private static void wallBfs() {
        int len = wq.size();
        for (int l = 0; l < len; l++) {
            int[] now = wq.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (board[x][y] == '.' && sv[x][y] && !sv[now[0]][now[1]]) {
                        sv[now[0]][now[1]] = true;
                        sq.add(new int[]{now[0],now[1]});
                    }
                    if (board[x][y] == 'X' && !wv[x][y]) {
                        wq.add(new int[]{x, y});
                        wv[x][y] = true;
                    }
                }
            }
        }
    }

    private static void wallInit() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X' && !wv[i][j]) {
                    for (int d = 0; d < 4; d++) {
                        int x = i + dx[d];
                        int y = j + dy[d];
                        if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] != 'X') {
                            wv[i][j] = true;
                            wq.add(new int[]{i, j});
                            break;
                        }
                    }
                }
            }
        }

    }

    private static void changeWq() {
        Iterator<int[]> iter = wq.iterator();
        while (iter.hasNext()) {
            int[] now = iter.next();
            board[now[0]][now[1]] = '.';
        }
    }
}
/**
 * ...X.......
 * ....X......
 * .....X.....
 * ..L...X....
 */