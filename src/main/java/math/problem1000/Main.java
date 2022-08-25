package math.problem1000;

import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStream stream = IntStream.of(sc.nextInt(), sc.nextInt());
        OptionalInt sum = stream.reduce((x, y) -> x + y);
        sum.ifPresent(System.out::println);
        sc.close();
    }
}
