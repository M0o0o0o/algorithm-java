package greedy.problem13164;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13164
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> diff = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            diff.add(list.get(i + 1) - list.get(i));
        }

        Collections.sort(diff);
        System.out.println(diff.toString());
        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            ans += diff.get(i);
        }
        System.out.println(ans);

        br.close();
    }
}
