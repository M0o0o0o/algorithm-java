package implementation.problem23290;

import java.util.*;

public class Main {
    static int[][] smell = new int[5][5];
    static int[][] board = new int[5][5];
    static int n = 4;
    static int m, s, sx, sy;
    static int[] fx = {0,0, -1, -1, -1, 0, 1, 1, 1};
    static int[] fy = {0,-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, -1, 0, 1};
    static ArrayList<ArrayList<Queue<Fish>>> fish = new ArrayList<>();
    static Queue<Fish> copyQ = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        s = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            fish.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                fish.get(i).add(new LinkedList<>());
            }
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            board[x][y]++;
            fish.get(x).get(y).add(new Fish(x, y, d, false));
        }

        sx = sc.nextInt();
        sy = sc.nextInt();

        while (s-- > 0) {
            copy();
            countSmell();
            fishMove();
            sharkMove();
            removeSmell();
            implementCopy();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(fish.get(i).get(j).size() + " ");
            }
            System.out.println();
        }


        sc.close();
    }

    private static void copy() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Queue<Fish> q = fish.get(i).get(j);
                for (Fish f : q) {
                    f.isMove = false;
                    copyQ.add(new Fish(f));
                }
            }
        }
    }

    private static void fishMove() {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                Queue<Fish> q = fish.get(r).get(c);

                for (Fish f : q) {
                    if(f.isMove) continue;
                    int d = f.d;
                    boolean isFind = false;
                    for (int i = 0; i < 8; i++) {
                        if(d==0) d = 8;
                        int nx = f.x + fx[d];
                        int ny = f.y + fy[d];
                        if (1 > nx || nx > n || 1 > ny || ny > n || (nx == sx && ny == sy) || smell[nx][ny] >= 1) {
                            d--;
                            continue;
                        }

                        isFind = true;
                        fish.get(nx).get(ny).add(new Fish(nx, ny, d, true));
                        q.poll();
                        break;
                    }
                    if (!isFind) {
                        f.isMove = true;
                    }
                }
            }
        }
    }

    private static void sharkMove() {
        int kill = 0;
        int Order = 0;
        for (int i = 1; i <= 4; i++) {
            int x = sx + dx[i];
            int y = sy + dy[i];
            if(1 > x || x > n || 1 > y || y > n) continue;
            for (int j = 1; j <= 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(1 > nx || nx > n || 1 > ny || ny > n) continue;
                for (int k = 1; k <= 4; k++) {
                    int nnx = nx + dx[j];
                    int nny = ny + dy[j];
                    if(1 > nnx || nnx > n || 1 > nny || nny > n) continue;
                    int size = fish.get(x).get(y).size() + fish.get(nx).get(ny).size() + fish.get(nnx).get(nny).size();
                    int order = (i * 100) + (j * 10) + k;

                    if (size > kill) {
                        kill = size;
                        Order = order;
                    } else if (size == kill && order > Order) {
                        Order = order;
                    }
                }
            }
        }
        int x = sx;
        int y = sy;
        String[] order = String.valueOf(Order).split("");
        System.out.println(Arrays.toString(order));
        System.out.println(x + "  " + y);
        for (String d : order) {
            x += dx[Integer.valueOf(d)];
            y += dy[Integer.valueOf(d)];
            System.out.println(x + "  " + y);
            if (fish.get(x).get(y).size() > 0) {
                fish.get(x).get(y).clear();
                smell[x][y] = 1;
            }
        }

        sx = x;
        sy = y;

    }

    private static void removeSmell() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (smell[i][j] == 3) smell[i][j] = 0;
            }
        }
    }

    private static void countSmell() {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(smell[i][j] >= 1) smell[i][j]++;
            }
        }
    }

    private static void implementCopy() {
        while (!copyQ.isEmpty()) {
            Fish f = copyQ.poll();
            fish.get(f.x).get(f.y).add(new Fish(f));
        }
    }
}

class Fish {
    int x, y, d;
    boolean isMove;

    public Fish(int x, int y, int d, boolean isMove) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.isMove = isMove;
    }

    public Fish(Fish o) {
        this.x = o.x;
        this.y = o.y;
        this.d = o.d;
        this.isMove = o.isMove;
    }
}