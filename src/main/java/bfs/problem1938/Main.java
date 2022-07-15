package bfs.problem1938;

import java.util.*;

//https://www.acmicpc.net/problem/1938
public class Main {
    static int n;
    static char[][] board;
    static Queue<Node> q = new LinkedList<>();
    static HashMap<Node, Integer> visited = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String buf = sc.next();
            for (int j = 0; j < buf.length(); j++) {
                board[i][j] = buf.charAt(j);
            }
        }
        Node target = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'B') {
                    Node start = find(i, j);
                    q.add(start);
                    visited.put(start, 0);

                }
                if (board[i][j] == 'E') {
                    target = find(i, j);
                }
            }
        }

        bfs();
        if (visited.containsKey(target)) {
            System.out.println(visited.get(target));
        } else System.out.println(0);
    }


    public static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = -1; i < 4; i++) {
                Node next = null;
                if (i == -1) {
                    next = rotate(now);
                } else {
                    next = move(now, i);
                }

                if (next != null && (!visited.containsKey(next) || visited.get(next) > visited.get(now) + 1)) {
                    q.add(next);
                    visited.put(next, visited.get(now) + 1);
                }

            }

        }
    }

    public static Node rotate(Node now) {
        int x = now.x2;
        int y = now.y2;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {

                if(i < 0 || i >= n || j < 0|| j >= n || board[i][j] == '1') return null;
            }
        }
        if (now.x1 == x - 1 && now.y1 == y) { //수직
            return new Node(now.x1 + 1, now.y1 -1, now.x2, now.y2, now.x3 - 1, now.y3 + 1);
        } else { // 수평
            return new Node(now.x1 - 1, now.y1 + 1, now.x2, now.y2, now.x3 + 1, now.y3 - 1);
        }
    }

    public static Node move(Node now, int d) {
        int[][] point = new int[][]{{now.x1, now.y1}, {now.x2, now.y2}, {now.x3, now.y3}};
        for (int i = 0; i < point.length; i++) {
            int nx = point[i][0] + dx[d];
            int ny = point[i][1] + dy[d];
            if(0 > nx || nx >= n || 0 > ny || ny >= n || board[nx][ny] == '1') return null;
        }

        return new Node(now.x1 + dx[d], now.y1 + dy[d], now.x2 + dx[d], now.y2 + dy[d], now.x3 + dx[d], now.y3 + dy[d]);
    }

    public static Node find(int x, int y) {
        char check = board[x][y];
        if (y != n-1 && board[x][y + 1] == check) {
            board[x][y] = '0';
            board[x][y + 1] = '0';
            board[x][y + 2] = '0';
            return new Node(x, y, x, y + 1, x, y + 2);
        } else {
            board[x][y] = '0';
            board[x + 1][y] = '0';
            board[x + 2][y] = '0';
            return new Node(x, y, x + 1, y, x + 2, y);
        }
    }


    public static class Node {
        int x1,y1,x2,y2,x3, y3;

        public Node(int x1, int y1, int x2, int y2, int x3, int y3) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x1 == node.x1 && y1 == node.y1 && x2 == node.x2 && y2 == node.y2 && x3 == node.x3 && y3 == node.y3;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2, x3, y3);
        }

        @Override
        public String toString() {
            return "" + "(" + x1 + "," + y1 + ") " + "(" + x2 + "," + y2 + ") " + "(" + x3 + "," + y3 + ")";
        }

    }
}

