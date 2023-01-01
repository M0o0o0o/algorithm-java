package programmers.season1.lessons67259;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean[][][] visited;
    int dx[] = {0, 1, 0, -1};
    int dy[] = {1, 0, -1, 0};
    int n;

    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n][4];

        return bfs(board);
    }

    public int bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        visited[0][0][0] = visited[0][0][1] = visited[0][0][2] = visited[0][0][3] = true;
        q.add(new Node(0, 0, -1, 0));

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.x == n-1 && curr.y == n-1 && min > curr.cost) min = curr.cost;

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != 1) {
                    int cost = curr.cost;
                    if(curr.dir == i || curr.dir == -1) cost += 100;
                    else cost += 600;

                    if (!visited[nx][ny][i] || board[nx][ny] >= cost) {
                        q.add(new Node(nx, ny, i, cost));
                        visited[nx][ny][i] = true;
                        board[nx][ny] = cost;
                    }
                }
            }
        }

        return min;
    }


    public class Node {
        int x, y, dir, cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}