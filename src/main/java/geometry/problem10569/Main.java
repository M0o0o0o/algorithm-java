package geometry.problem10569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(-Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + 2);
        }
        br.close();
    }
}
