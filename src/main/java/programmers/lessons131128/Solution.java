package programmers.lessons131128;




import java.util.HashMap;

class Solution {
    public String solution(String X, String Y) {
        boolean[] XChecked = new boolean[10];
        boolean[] YChecked = new boolean[10];

        HashMap<Integer, Integer> XMap = new HashMap<>();
        HashMap<Integer, Integer> YMap = new HashMap<>();

        calculate(X, XChecked, XMap);
        calculate(Y, YChecked, YMap);

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            if(!XChecked[i] || !YChecked[i]) continue;

            if (i == 0 && sb.length() == 0) {
                sb.append("0");
                continue;
            }

            for (int j = 0; j < Math.min(XMap.get(i), YMap.get(i)); j++) {
                sb.append(i);
            }
        }


        if (sb.length() == 0) {
            return "-1";
        }

        return sb.toString();
    }

    private void calculate(String numbers, boolean[] checked, HashMap<Integer, Integer> map) {
        for (int i = 0; i < numbers.length(); i++) {
            int now = numbers.charAt(i) - '0';
            checked[now] = true;
            if (map.containsKey(now)) {
                map.put(now, map.get(now) + 1);
                continue;
            }
            map.put(now, 1);
        }
    }


}