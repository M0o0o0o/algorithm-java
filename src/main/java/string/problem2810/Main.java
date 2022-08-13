package string.problem2810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static String seats;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        seats = br.readLine();

        int beforeCnt = seats.length();
        String newSeats = seats.replaceAll("LL", "S");
        int afterCnt = newSeats.length();

        System.out.println(Math.min(afterCnt + 1, beforeCnt));

        br.close();

    }
}
