package implementation.problem16235;

import java.util.*;

//https://www.acmicpc.net/problem/16235
public class Main {
    static int n, m, k;
    static int[][] board, a;
    static ArrayList<ArrayList<PriorityQueue<Integer>>> trees = new ArrayList<>();

    static Stack<Integer> buf = new Stack<>();
    static final int[] DX = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] DY = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) {
        input();
        for (int i = 0; i < k; i++) {
            getAgeAndDie();
            makeChild();
            winter();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += trees.get(i).get(j).size();
            }
        }
        System.out.println(ans);

    }

    public static void getAgeAndDie() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                PriorityQueue<Integer> q = trees.get(i).get(j);
                int size = q.size();
                int cnt = 0;
                for (int l = 0; l < size; l++) {
                    int now = q.poll();
                    if (board[i][j] >= now) {
                        board[i][j] -= now;
                        buf.add(now + 1);
                    } else {
                        cnt += now / 2;
                    }
                }
                board[i][j] += cnt;
                while (!buf.isEmpty()) {
                    trees.get(i).get(j).add(buf.pop());
                }
            }
        }
        return;
    }

    public static void makeChild() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                PriorityQueue<Integer> q = trees.get(i).get(j);
                Iterator<Integer> iter = q.iterator();
                while (iter.hasNext()) {
                    int now = iter.next();
                    if (now % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            if (0 <= i + DX[d] && n > i + DX[d] && 0 <= j + DY[d] && n > j + DY[d]) {
                                trees.get(i + DX[d]).get(j + DY[d]).add(1);
                            }
                        }
                    }
                }
            }
        }

    }

    public static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] += a[i][j];
            }
        }
    }
    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        board = new int[n][n];
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            trees.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                trees.get(i).add(new PriorityQueue<>());
                a[i][j] = sc.nextInt();
                board[i][j] = 5;
            }
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int age = sc.nextInt();
            trees.get(x - 1).get(y - 1).add(age);
        }
    }
}
