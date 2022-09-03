package programmers.kakao2022.five;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    int n = 51;
    String[][] board = new String[n][n];
    HashMap<Set<String>, String> mergeValue = new HashMap<>();
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();

        for (String command : commands) {


            String[] c = command.split(" ");
            if (c[0].equals("UPDATE")) {
                if (c.length == 4) {
                    update(Integer.parseInt(c[1]) , Integer.parseInt(c[2]) , c[3]);
                }else {
                    update2(c[1], c[2]);
                }
            } else if (c[0].equals("MERGE")) {
                merge(Integer.parseInt(c[1]) ,Integer.parseInt(c[2]),Integer.parseInt(c[3]),Integer.parseInt(c[4]));
            } else if (c[0].equals("UNMERGE")) {
                unmerge(c[1], c[2]);
            }else {
                answer.add(print(c[1], c[2]));
            }

        }
        return answer.toArray(new String[answer.size()]);
    }

    public void update(int r, int c, String value) {
        String location = "" + r + "," + c;
        boolean find = false;
        for (Set<String> strings : mergeValue.keySet()) {
            if (strings.contains(location)) {
                find = true;
                mergeValue.put(strings, value);
                break;
            }
        }
        if (!find) {
            board[r][c] = value;
        }
        return;
    }
// 고치자
    public void update2(String before, String after) {
        Set<String> cellSet = null;
        for (Set<String> strings : mergeValue.keySet()) {
            if (mergeValue.get(strings).equals(before)) {
                cellSet = strings;
                mergeValue.put(strings, after);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (cellSet != null && cellSet.contains(i + "," + j)) {
                    continue;
                }
                if (board[i][j] != null && board[i][j].equals(before)) {
                    board[i][j] = after;
                }
            }
        }
        return;
    }

    public void merge(int r1, int c1, int r2, int c2) {
        Set<String> first = null;
        Set<String> second = null;

        for (Set<String> strings : mergeValue.keySet()) {
            if (first == null && strings.contains(r1 + "," + c1)) {
                first = strings;
            }
            if (second == null && strings.contains(r2 + "," + c2)) {
                second = strings;
            }
        }
        if (first == null && second == null) {
            // 둘 다 셋이 아닌 경우
            String value = board[r1][c1] == null ? board[r2][c2] : board[r1][c1];
            Set<String> buf = new HashSet<>();
            buf.add(r1 + "," + c1);
            buf.add(r2 + "," + c2);
            mergeValue.put(buf, value);

        } else if (first != null && second == null) {
            // first만 셋인 경우
            String value = mergeValue.get(first);
            mergeValue.remove(first);
            first.add(r2 + "," + c2);
            mergeValue.put(first, value);

        } else if (first == null && second != null) {
            String value = board[r1][c1] == null ? mergeValue.get(second) : board[r1][c1];
            mergeValue.remove(second);
            second.add(r1 + "," + c1);
            mergeValue.put(second, value);

        }else {
            String value = mergeValue.get(first);
            Set<String> mergeSet = new HashSet<>();
            mergeSet.addAll(first);
            mergeSet.addAll(second);
            mergeValue.remove(first);
            mergeValue.remove(second);
            mergeValue.put(mergeSet, value);
        }

    }
    public void unmerge(String r, String c) {
        Set<String> buf = null;
        for (Set<String> strings : mergeValue.keySet()) {
            if (strings.contains(r + "," + c)) {
                buf = strings;
                break;
            }
        }
        if(buf == null) return;


        Iterator<String> iter = buf.iterator();
        while (iter.hasNext()) {
            String[] split = iter.next().split(",");

            board[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = null;
        }
        board[Integer.parseInt(r)][Integer.parseInt(c)] = mergeValue.get(buf);
        mergeValue.remove(buf);
    }

    public String print(String r, String c) {
        Set<String> buf = null;
        for (Set<String> strings : mergeValue.keySet()) {
            if (strings.contains(r + "," + c)) {
                buf = strings;
                break;
            }
        }

        if (buf == null) {
            if (board[Integer.parseInt(r)][Integer.parseInt(c)] == null) {
                return "EMPTY";
            }
            return board[Integer.parseInt(r)][Integer.parseInt(c)];
        }
        return mergeValue.get(buf);
    }
}