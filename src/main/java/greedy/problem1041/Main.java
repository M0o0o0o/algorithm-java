package greedy.problem1041;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1041
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        // 0, 1, 2 ,3 , 4, 5

        sc.close();
    }
}
