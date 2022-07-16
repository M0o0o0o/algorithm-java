package implementation.probelm19236;

import java.util.*;

public class Main {
    // ↑, ↖, ←, ↙, ↓, ↘, →, ↗

    static int n = 4;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[][][] board = new int[4][4][2];
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j][0] = sc.nextInt();
                board[i][j][1] = sc.nextInt() - 1;
            }
        }


        dfs(0, 0, board[0][0][0], board[0][0][1], board);

        System.out.println(ans);

        sc.close();

    }

    public static void dfs(int x, int y, int total, int d, int[][][] board) {
        board[x][y][0] = board[x][y][1] = -1;

        // 물고기들의 이동
        int[][][] nBoard = move(board, x, y);

        System.out.println("물고기 이동 후 ");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("(" + board[i][j][0] + "," + board[i][j][1] + ")" + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        // 상어 이동 가능한 지 확인 후에 가능하다면 리스트에 넣는다.
        ArrayList<int[]> list = new ArrayList<>();
        while (true) {
            x += dx[d];
            y += dy[d];

            if (x >= 0 && x < n && y >= 0 && y < n) {
                if(nBoard[x][y][0] != -1) list.add(new int[]{x, y});
            } else break;
        }

        if (list.size() == 0) {
            ans = Math.max(ans, total);
        }

        // 상어 가능한 이동 경로 ㄱ
        for (int[] next : list) {
            int nx = next[0];
            int ny = next[1];
            dfs(nx, ny, total + nBoard[nx][ny][0], nBoard[nx][ny][1], nBoard);

        }
    }

    public static int[][][] move(int[][][] board, int sx, int sy) {
        System.out.println("move 현재 상어 위치 : " + sx + " " + sy);

        int[][][] nBoard = new int[n][n][2];
        HashMap<Integer, int[]> list = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nBoard[i][j][0] = board[i][j][0];
                nBoard[i][j][1] = board[i][j][1];
                if (nBoard[i][j][0] != -1) {
                    list.put(nBoard[i][j][0], new int[]{i, j});
                }
            }
        }

        for (int i = 1; i <= 16; i++) {
            if(!list.containsKey(i)) continue;
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            int d = nBoard[x][y][1];
            System.out.println(i + " " + d);
            for (int j = 0; j < 8; j++) {

                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && (nx != sx || ny != sy)) {
                    int nw = nBoard[nx][ny][0];
                    int nd = nBoard[nx][ny][1];
                    if (nw != -1) {

                        System.out.println(i + " " + nw  +"와 변경");
                        System.out.println(d +" " + nx + " " + ny);
                        System.out.println();
                        list.get(nw)[0] = x;
                        list.get(nw)[1] = y;
                    }

                    nBoard[nx][ny][0] = nBoard[x][y][0];
                    nBoard[nx][ny][1] = nBoard[x][y][1];
                    nBoard[x][y][0] = nw;
                    nBoard[x][y][1] = nd;

                    break;
                }
                d++;
                if(d==8) d = 0;
            }
        }


        return nBoard;
    }
}
