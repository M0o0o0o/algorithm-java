package programmers.lessons60059;

class Solution {
    private int kLen, lLen;
    private int[][] checkBoard;
    public boolean solution(int[][] key, int[][] lock) {
        kLen = key.length;
        lLen = lock.length;
        checkBoard = new int[lLen][lLen];


        for (int R = 0; R <= 5; R++) {
            for (int i = -lLen; i < lLen; i++) {
                for (int j = -lLen; j < lLen; j++) {
                    if (check(key, lock, i, j)) {
                        return true;
                    }
                }
            }
            rotate90(key);
        }
        return false;
    }

    private boolean check(int[][] key, int[][] lock, int x, int y) {
        init(lock);

        for (int i = 0; i < kLen; i++) {
            for (int j = 0; j < kLen; j++) {
                if(i + x >= lLen || j + y >= lLen || i + x < 0 || j + y < 0) continue;
                checkBoard[i + x][j + y] += key[i][j];
            }
        }
        for (int i = 0; i < lLen; i++) {
            for (int j = 0; j < lLen; j++) {
                if(checkBoard[i][j] != 1) return false;
            }
        }
        return true;
    }

    private void rotate90(int[][] key) {
        int[][] arr2 = new int[kLen][kLen]; // 행, 열을 반대로
        for (int i = 0; i < kLen; i++) {
            for (int j = 0; j < kLen; j++) {
                arr2[i][j] = key[kLen - 1 - j][i]; // ##핵심 코드##
            }
        }

        for (int i = 0; i < kLen; i++) {
            for (int j = 0; j < kLen; j++) {
                key[i][j] = arr2[i][j];
            }
        }
        return;
    }

    private void init(int[][] lock) {
        for (int i = 0; i < lLen; i++) {
            for (int j = 0; j < lLen; j++) {
                checkBoard[i][j] = lock[i][j];
            }
        }
        return;
    }
}



