package geometry.problem7510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            Arrays.sort(arr);
            System.out.println("Scenario #" + (i + 1) + ":");
            if (Math.sqrt((int) Math.pow((double) arr[0], 2.0) + Math.pow((double) arr[1], 2.0)) == arr[2]) {
                System.out.println("yes");
            } else {
                System.out.println("no");

            }
            System.out.println();
        }
        br.close();
    }
}
