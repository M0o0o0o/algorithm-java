package programmers.lessons72414;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = timeConvertInt(play_time);
        int adv = timeConvertInt(adv_time);

        int[] ad = new int[360_000];

        for(String log : logs) {
            String[] l = log.split("-");
            int start = timeConvertInt(l[0]);
            int end =  timeConvertInt(l[1]);
            for(int i=start; i<end; i++) {
                ad[i]++;
            }
        }

        int max_idx=0;
        long max_sum=0;
        long sum =0;
        for(int i=0; i<adv; i++) {
            sum += ad[i];
        }
        max_sum = sum;

        for(int i = adv; i<play; i++) {
            sum += ad[i] - ad[i-adv];
            if(sum > max_sum) {
                max_sum = sum;
                max_idx = i-adv+1;
            }
        }

        return timeToString(max_idx);

    }
    static int timeConvertInt(String time) {
        String[] times = time.split(":");
        int toSec = 3600;
        int totalTime = 0;
        for(String t : times) {
            int num = Integer.parseInt(t);
            totalTime += num*toSec;
            toSec /= 60;
        }
        return totalTime;
    }

    static String timeToString(int time) {
        String t = "";
        int hour = time/3600;
        time %= 3600;
        if(hour <10) t+= "0"+ hour +":";
        else t += hour+":";

        int minute = time/60;
        time %= 60;
        if(minute <10) t+= "0"+ minute+":";
        else t += minute+":";

        int second = time;
        if(second <10) t+= "0"+ second;
        else t += second;

        return t;
    }
}