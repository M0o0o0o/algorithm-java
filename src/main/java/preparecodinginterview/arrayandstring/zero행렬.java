package preparecodinginterview.arrayandstring;

import java.util.LinkedList;
import java.util.Queue;

/**
 * M x N 행렬의 한 원소가 0일 경우,
 * 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라
 */
public class zero행렬 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[][] solve(int[][] board) {


        Queue<int[]> q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] zero = q.poll();
            for (int d = 0; d < 4; d++) {
                int x = zero[0];
                int y = zero[1];

                while (true) {
                    x += dx[d];
                    y += dy[d];
                    if (x < 0 || x >= n || y < 0 || y >= m) break;
                    board[x][y] = 0;
                }
            }
        }

        return board;
    }
}
