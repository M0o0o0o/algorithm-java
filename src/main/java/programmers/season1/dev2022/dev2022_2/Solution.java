package programmers.season1.dev2022.dev2022_2;

import java.util.*;

class Solution {
    HashMap<Character, Integer> countries;
    char[][] board;
    boolean[][] visited;
    int row;
    int col;

    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};


    public int solution(String[] maps) {
        countries = new HashMap<>();
        row = maps.length;
        col = maps[0].length();
        board = new char[row][col];
        visited = new boolean[row][col];


        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char land = maps[i].charAt(j);
                board[i][j] = land;
                if(land == '.') continue;
                if (!countries.containsKey(land)) {
                    countries.put(land, 1);
                    continue;
                }
                countries.put(land, countries.get(land) + 1);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(visited[i][j] || board[i][j] == '.') continue;
                HashMap<Character, Integer> result = bfs(i, j);
                calculator(result);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (Character key : countries.keySet()) {

            ans = Math.max(ans, countries.get(key));
        }
        return ans;
    }

    private void calculator(HashMap<Character, Integer> result) {
        Set<Character> keySet = result.keySet();
        List<int[]> resultArr = new ArrayList<>();
        keySet.stream().forEach(key -> {
            resultArr.add(new int[]{key, result.get(key)});
        });

        resultArr.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });

        int maxCount = resultArr.get(0)[1];
        char winCountry = (char) resultArr.get(0)[0];


        for (int[] unit : resultArr) {
            if (unit[1] < maxCount) {
                countries.put(winCountry, countries.get(winCountry) + unit[1]);
                countries.put((char) unit[0], countries.get((char) unit[0]) - unit[1]);

            }
        }


    }

    public HashMap<Character, Integer> bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        HashMap<Character, Integer> countMap = new HashMap<>();

        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        countMap.put(board[startX][startY], 1);

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                // 조건은 (row, col), 빈 칸 아니고, visited
                if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                    if(board[x][y] == '.') continue;
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                    if (!countMap.containsKey(board[x][y])) {
                        countMap.put(board[x][y], 1);
                        continue;
                    }
                    countMap.put(board[x][y], countMap.get(board[x][y]) + 1);
                }
            }
        }

        return countMap;
    }
}