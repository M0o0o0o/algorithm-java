import bfs.problem1938.Main;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Node one = new Node(new int[][]{{1, 1}, {1, 1}, {1, 1}});
        Node two = new Node(new int[][]{{1, 1}, {1, 1}, {1, 1}});
        HashMap<Node, Integer> text = new HashMap<>();
        text.put(one, 1);
        System.out.println(text.containsKey(two));


    }


    public static class Node {
        int[][] point;

        public Node(int[][] point) {
            this.point = point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    if(node.point[i][j] != this.point[i][j]) return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(point);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "point=" + Arrays.toString(point[0]) + ", " + Arrays.toString(point[1]) + ", " + Arrays.toString(point[2]) +
                    '}';
        }
    }
}

