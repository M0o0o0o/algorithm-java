package programmers.season1.lessons135807;

import java.util.Arrays;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int answer = 0;
        int limit = Math.max(arrayA[0], arrayB[0]);
        System.out.println(limit);


        for (int i = 2; i <= limit; i++) {
            if(canDivideAllNumbers(arrayA, i) && cannotDivideAllNumbers(arrayB,i)) answer = i;
            else if(canDivideAllNumbers(arrayB, i) && cannotDivideAllNumbers(arrayA,i)) answer = i;
        }

        return answer;
    }

    private boolean canDivideAllNumbers(int[] array, int i) {
        for (int num : array) {
            if(num % i != 0) return false;
        }
        return true;
    }

    private boolean cannotDivideAllNumbers(int[] array, int i) {
        for (int num : array) {
            if(num % i == 0) return false;
        }
        return true;
    }
}