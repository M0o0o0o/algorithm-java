package sort.problem2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(i, new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else return o1[0] - o2[0];
            }
        });


        int ans = 0;
        int start = -1000000001;
        int end = -1000000001;
        for (int i = 0; i < n; i++) {
            int[] next = list.get(i);
            if (next[0] >= start && next[0] <= end) {
                end = Math.max(end, next[1]);
            } else {
                ans += end - start;
                start = next[0];
                end = next[1];
            }

        }
        System.out.println(ans + (end - start));

        br.close();
    }
}
