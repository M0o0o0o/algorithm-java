package programmers.season1.kakao2022.one;


import java.util.*;

class Solution {


    HashMap<String, Integer> termMap;
    public int[] solution(String today, String[] terms, String[] privacies) {
        termMap = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            termMap.put(s[0], Integer.parseInt(s[1]));
        }

        // 오늘 날짜 구하기
        int[] todayArr = new int[]{
                Integer.parseInt(today.substring(0, 4)), Integer.parseInt(today.substring(5, 7)), Integer.parseInt(today.substring(8))};


        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] dateAndTerm = privacies[i].split(" ");
            int[] date = new int[]{
                    Integer.parseInt(dateAndTerm[0].substring(0, 4)), Integer.parseInt(dateAndTerm[0].substring(5, 7)), Integer.parseInt(dateAndTerm[0].substring(8))};
            if (calculator(date, termMap.get(dateAndTerm[1]), todayArr)) {
                answer.add(i + 1);
            }


        }

        answer.sort(Comparator.comparingInt(one -> one));
        return  answer.stream().mapToInt(i -> i).toArray();
    }


    public boolean calculator(int[] date, int days, int[] today) {

        days = days * 28 - 1;

        // 일 구하기
        date[2] += days;
        date[1] += date[2] / 28;
        date[2] %= 28;

        date[0] += date[1] / 12;
        date[1] %= 12;


        if (date[2] == 0) {
            date[2] = 28;
            date[1] -= 1;
        }
        if (date[1] == 0) {
            date[1] = 12;
            date[0] -= 1;
        }

        if (today[0] > date[0]) {
            return true;
        }
        if (today[0] == date[0]) {
            if (today[1] > date[1]) {
                return true;
            }
        }
        if (today[0] == date[0] && today[1] == date[1]) {
            if (today[2] > date[2]) {
                return true;
            }
        }
        return false;
    }
}