package string.problem20154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Character, Integer> convertMap = new HashMap<>();
    static Queue<Integer> q = new LinkedList<>();
    static int[] order = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 65; i < 91; i++) {
            convertMap.put((char) i, order[i - 65]);
        }


        for (int i = 0; i < str.length(); i++) {
            q.add(convertMap.get(str.charAt(i)));
        }

        while (q.size() > 1) {
            solve();
        }
        if (q.poll() % 2 == 0) {
            System.out.println("You're the winner?");
        } else {
            System.out.println("I'm a winner!");
        }
        br.readLine();
    }
    private static void solve() {
        Queue<Integer> buf = new LinkedList<>();
        while (q.size() >= 2) {
            buf.add((q.poll() + q.poll()) % 10);
        }
        if(!q.isEmpty()) buf.add(q.poll());
        q = buf;
    }
}
