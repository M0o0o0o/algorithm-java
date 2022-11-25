package programmers.lessons77485;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = num++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = calc(board, rows, columns, queries[i]);
        }

        return ans;
    }

    private int calc(int[][] board, int rows, int columns, int[] q) {
        int r1 = q[0] - 1, c1 = q[1] - 1, r2 = q[2] - 1, c2 = q[3] - 1;
        int minValue = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[rows][columns];
        visited[r1][c1] = true;
        int d = 0;
        int x = r1 + dx[d], y = c1 + dy[d];
        int store = board[r1][c1];

        while (true) {
            int buf = board[x][y];
            board[x][y] = store;
            store = buf;
            minValue = Math.min(store, minValue);

            if(visited[x][y]) break;
            visited[x][y] = true;

            int nx = x + dx[d], ny = y + dy[d];
            if (!(nx >= r1 && ny >= c1 && nx <= r2 && ny <= c2)) {
                d++;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx;
            y = ny;
        }
        return minValue;

    }
}