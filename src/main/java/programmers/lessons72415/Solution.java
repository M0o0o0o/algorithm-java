package programmers.lessons72415;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/72415
class Solution {
    ArrayList<Pair> lists = new ArrayList<>();
    int n = 4;
    int cnt = 0;
    int ans = Integer.MAX_VALUE;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    public int solution(int[][] board, int r, int c) {
        fillLists(board);
        dfs(board, 0, 0, r, c);
        return ans + (cnt * 2);
    }

    private void dfs(int[][] board, int cnt, int move, int x, int y) {
        if (cnt == this.cnt) {
            ans = Math.min(ans, move);
            return;
        }

        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).flag) {
                Pair p = lists.get(i);
                int moveA = move(board, x, y, p.x1, p.y1) + move(board, p.x1, p.y1, p.x2, p.y2);
                int moveB = move(board, x, y, p.x2, p.y2) + move(board, p.x2, p.y2, p.x1, p.y1);
                board[p.x1][p.y1] = 0;
                board[p.x2][p.y2] = 0;
                p.flag = true;
                if (moveA < moveB) {
                    dfs(board, cnt+1, move + moveA, p.x2, p.y2);
                } else {
                    dfs(board, cnt + 1, move + moveB, p.x1, p.y1);
                }
                p.flag = false;
                board[p.x1][p.y1] = p.type;
                board[p.x2][p.y2] = p.type;
            }
        }
    }

    public int move(int[][] board, int sx, int sy, int ex, int ey) {
        if(sx == ex && sy == ey) return 0;
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[sx][sy] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nx2 = x;
                int ny2 = y;
                while (true) {
                    nx2 += dx[i];
                    ny2 += dy[i];
                    if (0 > nx2 || nx2 >= n || 0 > ny2 || ny2 >= n) {
                        nx2 -= dx[i];
                        ny2 -= dy[i];
                        break;
                    }
                    if(board[nx2][ny2] > 0 ) break;
                }
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] > visited[x][y] + 1) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;
                }
                if ((x != nx2 || y != ny2) && visited[nx2][ny2] > visited[x][y] + 1) {
                    q.add(new int[]{nx2, ny2});
                    visited[nx2][ny2] = visited[x][y] + 1;
                }
            }
        }
        return visited[ex][ey];
    }

    private void fillLists(int[][] board) {
        HashMap<Integer, int[]> buf = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    int type = board[i][j];
                    if (buf.containsKey(board[i][j])) {
                        lists.add(new Pair(buf.get(type)[0], buf.get(type)[1], i, j, type, false));
                        cnt++;
                    } else {
                        buf.put(type, new int[]{i, j});
                    }
                }
            }
        }
        return;
    }
}


class Pair{
    int x1,y1,x2, y2;
    int type;
    boolean flag;

    public Pair(int x1, int y1, int x2, int y2, int type, boolean flag) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.type = type;
        this.flag = flag;
    }
}
