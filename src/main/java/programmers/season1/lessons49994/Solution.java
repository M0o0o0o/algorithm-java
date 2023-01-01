package programmers.season1.lessons49994;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(String dirs) {
        int ans = 0;
        char[] charArray = dirs.toCharArray();
        Set<History> set = new HashSet<>();

        int x = 0, y = 0;
        for (char m : charArray) {
            int d = findDirection(m);
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx <= 5 && nx >= -5 && ny <= 5 && ny >= -5) {
                History history = new History(x, y, d);
                if (!set.contains(history)) {
                    set.add(history);
                    set.add(new History(nx, ny, reverseDir(d)));
                    ans++;
                }
                x = nx;
                y = ny;
            }
        }
        return ans;
    }

    private int reverseDir(int d) {
        if(d==0) return 1;
        else if(d== 1) return 0;
        else if(d == 2) return 3;
        else return 2;
    }

    private int findDirection(char m) {
        if(m=='U') return 0;
        else if(m == 'D') return 1;
        else if(m == 'R') return 2;
        else return 3;
    }

    class History {
        int x;
        int y;
        int d;

        public History(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            History history = (History) o;
            return x == history.x && y == history.y && d == history.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, d);
        }
    }

}