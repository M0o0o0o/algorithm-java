package programmers.season1.lessons1838;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int n, int m, int[][] timetable) {
        int ans = 0;
        Arrays.sort(timetable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int[] now = timetable[i];
            for (int j = i; j < n; j++) {
                if(timetable[j][1] <= now[1]) cnt++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);


        return ans;
    }


}