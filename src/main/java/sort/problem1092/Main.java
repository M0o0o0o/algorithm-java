package sort.problem1092;

import java.io.IOException;
import java.util.*;

//https://www.acmicpc.net/problem/1092
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> crane = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            crane.add(sc.nextInt());
        }
        Collections.sort(crane, Collections.reverseOrder());

        int m = sc.nextInt();
        ArrayList<Integer> luggage = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            luggage.add(sc.nextInt());
        }
        Collections.sort(luggage, Collections.reverseOrder());

        if (crane.get(0) < luggage.get(0)) {
            System.out.println("-1");
            System.exit(0);
        }

        int ans = 0;
        while (!luggage.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < crane.size();) {
                if(idx == luggage.size()) break;
                if (crane.get(i) >= luggage.get(idx)) {
                    luggage.remove(idx);
                    i++;
                } else {
                    idx++;
                }
            }
            ans++;
        }

        System.out.println(ans);

    }

}
