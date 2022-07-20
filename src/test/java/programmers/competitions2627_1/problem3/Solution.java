package programmers.competitions2627_1.problem3;

import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        int n = order.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int num = 1;
        int i = 0;
        while (num < n + 1 || !stack.isEmpty()) {
            if (num == order[i]) {
                ans++;
                i++;
                num++;
                continue;
            }
            if (num < order[i]) {
                stack.push(num++);
                continue;
            }
            if(stack.isEmpty()) break;
            if(stack.peek() != order[i]) break;
            stack.pop();
            i++;
            ans++;

        }
        return ans;
    }
}