package implementation.problem12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/12904
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer(br.readLine());
        StringBuffer t = new StringBuffer(br.readLine());


        while (s.length() < t.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        if (t.toString().equals(s.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);

        }
    }
}
