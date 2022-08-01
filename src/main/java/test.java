import bfs.problem1938.Main;

import java.util.*;

public class test {
    public static void main(String[] args) {
        PriorityQueue<long[]> q = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] > o2[1]) return 1;
                else if (o1[1] < o2[1]) return -1;
                else return 0;
            }
        });
        q.add(new long[]{0, 3});
        q.add(new long[]{0, 1});
        q.add(new long[]{0, 2});
        System.out.println(Arrays.toString(q.poll()));
        System.out.println(Arrays.toString(q.poll()));
        System.out.println(Arrays.toString(q.poll()));
    }


}

