import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int num = 0;  
        int ans = 0;
        for(int[] timelog : timelogs){
               int cnt =0;
               int scheduleplus = schedules[num]+10;
               if((scheduleplus/10)%10==6){
                   int minute = scheduleplus%10;
                   scheduleplus = (scheduleplus/100)*100+100+minute;
               }
               num++;
            
                for(int i=0;i<timelog.length;i++){
                     int day = (startday+i)%7;
                     
                     if(day==6 || day ==0)
                           continue;
                     else{
                           int mytime = timelog[i];
                        
                            if(mytime<=scheduleplus)
                                cnt++;   
                     }
                  }
                if(cnt==5) ans++;
                }
        return ans;
           }
       }
    
