package dp.problem2602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = {br.readLine(), br.readLine()};
        int ans = 0;
        for (int select = 0; select <= 1; select++) {
            int[][] cnt = new int[s.length()+1][arr[0].length()+1];
            Arrays.fill(cnt[0], 1);
            for (int i = 1; i <= s.length(); i++) {
                String cur = arr[(i - select) & 1];
                for (int j = 1; j <= cur.length(); j++)
                    cnt[i][j] = cnt[i][j - 1] + (cur.charAt(j - 1) == s.charAt(i - 1) ? cnt[i - 1][j - 1] : 0);
            }
            ans += cnt[s.length()][arr[0].length()];
        }
        System.out.println(ans);

    }
}
/**
 * 반드시 마법의 두루마리에 적인 문자열의 순서대로 모두 밟고 지나가야 한다.
 * 반드시 악마, 천사의 돌다리를 번갈아가면서 돌을 밟아야 한다. 단, 출발은 어떤 돌다리에서 시작해도 된다.
 * 반드시 한 칸 이상 오른쪽으로 전진해야 하며, 건너뛰는 칸의 수에는 상관이 없다.
 */