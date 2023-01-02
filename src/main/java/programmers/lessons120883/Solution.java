package programmers.lessons120883;


class Solution {


    public String solution(String[] id_pw, String[][] db) {

        for (String[] strings : db) {
            if (id_pw[0].equals(strings[0])) {
                if (id_pw[1].equals(strings[1])) {
                    return "login";
                }
                return "wrong pw";
            }
        }


        return "fail";
    }
}