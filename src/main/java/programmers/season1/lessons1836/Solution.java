package programmers.season1.lessons1836;


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    char[][] board;
    int m, n;
    LinkedList<Character> list = new LinkedList<>();
    HashMap<Character, int[][]> map = new HashMap<>();

    public String solution(int m, int n, String[] board) {
        String ans = "";
        this.board = new char[m][n];
        this.m = m;
        this.n = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                this.board[i][j] = c;
                if (c != '.' && c != '*') {
                    if (!list.contains(c)) {
                        list.add(c);
                        map.put(c, new int[2][2]);
                        map.get(c)[0][0] = i;
                        map.get(c)[0][1] = j;
                    } else {
                        map.get(c)[1][0] = i;
                        map.get(c)[1][1] = j;
                    }
                }
            }
        }
        Collections.sort(list);

        int idx = 0;
        while (list.size() != 0) {
            if (isDel(list.get(idx))) {
                char target = list.remove(idx);
                ans += target;
                delete(target);
                idx = 0;
            } else {
                idx++;
                if (idx == list.size()) {
                    return "IMPOSSIBLE";
                }
            }
        }
        return ans;
    }

    boolean isDel(char a) {
        int r1 = map.get(a)[0][0];
        int c1 = map.get(a)[0][1];
        int r2 = map.get(a)[1][0];
        int c2 = map.get(a)[1][1];

        if(c1 < c2){
            if(linearColumnCheck(c1, c2, r1, a) && linearRowCheck(r1, r2, c2, a)){
                return true;
            }
            if(linearRowCheck(r1, r2, c1, a) && linearColumnCheck(c1, c2, r2, a)){
                return true;
            }
        }else{
            if(linearRowCheck(r1, r2, c2, a) && linearColumnCheck(c2, c1, r1, a)){
                return true;
            }
            if(linearColumnCheck(c2, c1, r2, a) && linearRowCheck(r1, r2, c1, a)){
                return true;
            }
        }
        return false;
    }

    void delete(char a) {
        board[map.get(a)[0][0]][map.get(a)[0][1]] = '.';
         board[map.get(a)[1][0]][map.get(a)[1][1]] = '.';
    }

    boolean linearRowCheck(int r1, int r2, int c, char a){
        for(int i = r1; i < r2+1; i++){
            if(board[i][c] != '.' && board[i][c] != a)
                return false;
        }
        return true;
    }

    boolean linearColumnCheck(int c1, int c2, int r, char a){
        for(int i = c1; i < c2+1; i++){
            if(board[r][i] != '.' && board[r][i] != a)
                return false;
        }
        return true;
    }
}

