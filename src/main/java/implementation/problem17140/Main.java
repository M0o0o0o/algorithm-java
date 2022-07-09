package implementation.problem17140;

import java.util.*;

public class Main {
    static int[][] board = new int[100][100];
    static int r, c, k;
    static int row = 3;
    static int col = 3;
    static HashMap<Integer, Integer> store = new HashMap<>();
    static PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }

    });
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        while (ans <= 100) {
            if(board[r-1][c-1] == k) break;
            if(row >= col) R();
            else C();
            ans++;
        }


        if(ans > 100) System.out.println(-1);
        else System.out.println(ans);
        sc.close();
        return;
    }

    public static void R() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 0) continue;
                if (store.containsKey(board[i][j])) store.put(board[i][j], store.get(board[i][j]) + 1);
                else store.put(board[i][j], 1);
            }

            Iterator<Integer> iter = store.keySet().iterator();
            while (iter.hasNext()) {
                int key = iter.next();
                if(store.get(key) == 0) continue;
                queue.add(new int[]{store.get(key), key});
                store.put(key, 0);
            }

            col = Math.max(col, Math.min(queue.size() * 2, 100));

            for (int j = 1; j < 100; j += 2) {
                if (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    board[i][j - 1] = now[1];
                    board[i][j] = now[0];

                } else {
                    board[i][j] = 0;
                    board[i][j - 1] = 0;
                }
            }

            queue.clear();
        }
    }

    public static void C() {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if(board[j][i] == 0 ) continue;
                if(store.containsKey(board[j][i])) store.put(board[j][i], store.get(board[j][i]) + 1);
                else store.put(board[j][i], 1);
            }

            Iterator<Integer> iter = store.keySet().iterator();
            while (iter.hasNext()) {
                int key = iter.next();
                if(store.get(key) ==0) continue;
                queue.add(new int[]{store.get(key), key});
                store.put(key, 0);
            }
            row = Math.max(row, Math.min(queue.size() * 2, 100));

            for (int j = 1; j < 100; j += 2) {
                if (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    board[j - 1][i] = now[1];

                    board[j][i] = now[0];
                } else {
                    board[j][i] = 0;
                    board[j - 1][i] = 0;
                }
            }
            queue.clear();
        }
    }
}
