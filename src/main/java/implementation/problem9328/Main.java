package implementation.problem9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int tc, n, m;
    static char[][] board;
    static boolean[][] visited;
    static HashSet<Character> key;
    static HashMap<Character, ArrayList<int[]>> unlock;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            board = new char[n][m];
            key = new HashSet<>();
            visited = new boolean[n][m];
            unlock = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String row = br.readLine();
                for (int k = 0; k < m; k++) {
                    board[j][k] = row.charAt(k);
                }
            }

            String initKey = br.readLine();
            if (!initKey.equals("0")) {
                for (int j = 0; j < initKey.length(); j++) {
                    key.add(initKey.charAt(j));
                }
            }
            System.out.println(bfs());

        }



    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    cnt += logic(q, i, j);
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            // 빈 칸인 경우, 문서를 찾은 경우, 대문자인데 키가 있는 경우(없는 경우), 소문자를 찾은 경우
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    cnt += logic(q, nx, ny);
                }
            }
        }
        return cnt;
    }

    public static int logic(Queue<int[]> q, int x, int y) {
        int cnt = 0;
        if (board[x][y] == '.' || (Character.isUpperCase(board[x][y])) && key.contains(Character.toLowerCase(board[x][y]))) {
            // 빈 칸 이거나 대문자 이면서 키가 있는 경우
            board[x][y] = '.';
            visited[x][y] = true;
            q.add(new int[]{x, y});
        } else if (Character.isLowerCase(board[x][y])) {
            key.add(board[x][y]);
            if (unlock.containsKey(Character.toUpperCase(board[x][y]))) {
                for (int[] un : unlock.get(Character.toUpperCase(board[x][y]))) {
                    board[un[0]][un[1]] = '.';
                    visited[un[0]][un[1]] = true;
                    q.add(new int[]{un[0], un[1]});
                }
            }
            board[x][y] = '.';
            visited[x][y] = true;
            q.add(new int[]{x, y});
        } else if (Character.isUpperCase(board[x][y])) {

            if (!unlock.containsKey(board[x][y])) unlock.put(board[x][y], new ArrayList<>());
            unlock.get(board[x][y]).add(new int[]{x, y});
        } else if (board[x][y] == '$') {
            cnt++;
            board[x][y] = '.';
            q.add(new int[]{x, y});
        }
        return cnt;
    }
}
