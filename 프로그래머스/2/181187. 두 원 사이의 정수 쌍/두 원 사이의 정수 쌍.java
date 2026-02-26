import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        //기본 4,4 
        long answer = 0;
         
        /* x^2 = r^2 - y^2  */
        for(int y=1;y<=r2;y++){
            double x2= Math.sqrt(Math.pow(r2,2)-Math.pow(y,2));
            double x1 = 0.0;
            if(y<=r1){
                x1 = Math.sqrt(Math.pow(r1,2)-Math.pow(y,2));
            }
         
            answer+= (long)Math.floor(x2)-(long)Math.ceil(x1)+1;
        
        }
        return answer*4;
        
    }
}