package programmers.competitions2627_1.problem4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    int ans = Integer.MAX_VALUE;
    Set<Integer> visited = new HashSet<>();
    ArrayList<Integer> checkArr = new ArrayList<>();

    int r, c;
    public int solution(int[][] beginning, int[][] target) {
        r = beginning.length;
        c = beginning[0].length;
        for (int i = 0; i < r; i++) {
            if (beginning[i][0] != target[i][0]) {
                visited.add(i+1);
                checkArr.add(i + 1);
            }
        }
        for (int i = 0; i < c; i++) {
            if (beginning[0][i] != target[0][i]) {
                visited.add(-(i+1));
                checkArr.add(-(i + 1));
            }
        }


        dfs(beginning, target, 0);

        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    public void dfs(int[][] board, int[][] target, int count) {

        if (visited.size() == 0) {
            if (match(board, target)) {
                ans = Math.min(ans, count);
            }
            return;
        }
        for (Integer a : checkArr) {
            if (visited.contains(a)) {
                if (a > 0) {
                    rowReverse(board, a - 1);
                } else {
                    colReverse(board, Math.abs(a) - 1);
                }
                visited.remove(a);
                dfs(board, target, count + 1);
                visited.add(a);
                if (a > 0) {
                    rowReverse(board, a - 1);
                } else {
                    colReverse(board, Math.abs(a) - 1);
                }

            }

        }
    }

    public void rowReverse(int[][] board, int idx) {
        for (int i = 0; i < c; i++) {
            board[idx][i] = board[idx][i] == 0 ? 1 : 0;
        }
        return;
    }

    public void colReverse(int[][] board, int idx) {
        for (int i = 0; i < r; i++) {
            board[i][idx] = board[i][idx] == 0 ? 1 : 0;
        }
        return;
    }

    public boolean match(int[][] board, int[][] target) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
}
