package programmers.season1.lessons87946;

class Solution {
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, visited, dungeons, 0);
        return answer;
    }

    private void dfs(int k, boolean[] visited, int[][] dungeons, int cnt) {
        answer = Math.max(cnt, answer);
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], visited, dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }
}