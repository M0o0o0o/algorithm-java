package programmers.level0.lessons120806;

class Solution {
    public int solution(int num1, int num2) {
        float share = (float) num1 / num2;
        System.out.println(share);
        return (int)(share * 1000);
    }
}