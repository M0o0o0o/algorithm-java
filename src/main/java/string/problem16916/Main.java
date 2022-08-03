package string.problem16916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(kmp(br.readLine(), br.readLine()));

        br.close();
    }

    static int kmp(String parent, String pattern) {
        int[] table = table(pattern);
        int n1 = parent.length();
        int n2 = pattern.length();

        int idx = 0;
        for(int i=0; i< n1; i++) {
            while(idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }
            if(parent.charAt(i) == pattern.charAt(idx)) {
                if(idx == n2-1) {
                    idx =table[idx];
                    return 1;
                }else {
                    idx += 1;
                }
            }
        }
        return 0;
    }

    static int[] table(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx=0;
        for(int i=1; i<n; i++) {
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }

            if(pattern.charAt(i) == pattern.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }

        return table;
    }
}
