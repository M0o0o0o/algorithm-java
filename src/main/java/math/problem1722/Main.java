package math.problem1722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long[] f = new long[21];
        boolean[] visited = new boolean[21];
        Arrays.fill(f, 1);
        for (int i = 1; i < 21; i++) {
            f[i] = f[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        if (q == 1) {
            long order = Long.parseLong(st.nextToken());
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[j]) continue;

                    if (f[n - i - 1] < order) {
                        order -= f[n - i - 1];
                    } else {
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else {
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long ans = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if(visited[j]) continue;
                    ans += f[n - i - 1];
                }
                visited[arr[i]] = true;
            }
            sb.append(ans);
        }

        System.out.println(sb.toString());

    }
}
