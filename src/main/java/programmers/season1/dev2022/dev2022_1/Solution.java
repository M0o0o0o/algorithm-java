package programmers.season1.dev2022.dev2022_1;

import java.util.HashSet;


class Solution {
    public String solution(String[] registered_list, String new_id) {
        HashSet<String> registeredSet = new HashSet<>();
        for (String s : registered_list) {
            registeredSet.add(s);
        }
        String answer = "";

        while(true)  {
            if (!registeredSet.contains(new_id)) {
                answer = new_id;
                break;
            }
            StringBuilder builder = new StringBuilder();
            int n = 0;
            for (int i = 0; i < new_id.length(); i++) {
                if (Character.isAlphabetic(new_id.charAt(i))) {
                    builder.append(new_id.charAt(i));
                    continue;
                }
                n = Integer.parseInt(new_id.substring(i));
                break;
            }
            String s = builder.toString();
            new_id = s + (n + 1);
        }

        return answer;
    }
}