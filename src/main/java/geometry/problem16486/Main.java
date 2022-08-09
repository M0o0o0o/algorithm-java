package geometry.problem16486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static double PI = 3.141592;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()) * 2;
        double b = 2 * PI * Integer.parseInt(br.readLine());
        System.out.println(a + b);
        br.close();

    }
}
