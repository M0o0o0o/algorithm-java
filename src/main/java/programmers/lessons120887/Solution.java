package programmers.lessons120887;

class Solution {
    public int solution(int i, int j, int k) {
        int ans = 0;
        for (int l = i; l <= j; l++) {
            ans += calc(l, k);

        }
        return ans;
    }

    private int calc(int number, int target) {
        int res = 0;
        while (number != 0) {
            if (target == (number % 10)) {
                res++;
            }

            number /= 10;
        }
        return res;
    }
}
