package math.problem10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        numbers.stream().mapToInt(v -> v).min().ifPresent(System.out::println);
        numbers.stream().mapToInt(v -> v).max().ifPresent(System.out::println);

        br.readLine();
    }
}
