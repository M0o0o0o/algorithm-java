package string.problem5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int m;
    private static int ans = 0;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        char s[] = br.readLine().toCharArray();

        for (int i = 1; i < m - 1; i++) {
            if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
                cnt++;

                if (cnt == n) {
                    cnt--;
                    ans++;
                }
                i++;
                continue;
            }
            cnt = 0;
        }
        System.out.println(ans);

    }
}
