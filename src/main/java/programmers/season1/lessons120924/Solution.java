package programmers.season1.lessons120924;

class Solution {
    public int solution(int[] common) {
        if ((common[1] - common[0]) + common[1] == common[2]) {
            return common[1] - common[0] + common[common.length-1];
        }
        return common[2] * (common[1] / common[0]);
    }
}