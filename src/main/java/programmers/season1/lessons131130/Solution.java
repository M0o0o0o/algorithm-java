package programmers.season1.lessons131130;


import java.util.Arrays;

class Solution {
    public int solution(int[] cards) {
        int answer = Integer.MIN_VALUE;
        boolean[] visited = new boolean[cards.length];

        for (int i = 0; i < cards.length; i++) {
            Arrays.fill(visited, false);

            int step1 = calc(cards, visited, i);
            if(step1 == cards.length){
                answer = Math.max(answer, 0);
                continue;
            }


            for (int j = 0; j < cards.length; j++) {
                if(visited[j]) continue;
                int step2 = calc(cards, visited, j);
                answer = Math.max(answer, step1 * step2);
            }
        }

        return answer;
    }

    private int calc(int[] cards, boolean[] visited, int i) {
        int cnt = 0;
        while (true) {
            if(visited[i]) return cnt;
            visited[i] = true;
            cnt++;
            i = cards[i] - 1;
        }
    }

}