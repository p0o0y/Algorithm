import java.util.*;

class Solution {
    public int solution(int storey) {
        // 시간복잡도 10^8 이라서 O(n) 만씀
        //2554 2550 (4) 2600(5) 3000(4)  0(3)
        //1단위 올/낼 10단위 100단위 ...
        
        //1. storey 자리수 알아내기
        String st = String.valueOf(storey);
        int len = st.length();
       
        int ans =0;
        
       while(storey>0){
            int remain = storey%10;
            if(remain>5) {
                storey+=(10-remain);
                ans+=10-remain;
            }
            else if (remain<5){
                storey-=remain;
                ans+=remain;
            }else{
                int next = (storey/10)%10;
                if(next>=5) storey+=(10-remain);
                else storey-=remain;
                ans+=remain;
                
            }
            storey = storey/10;
        }
        return ans;
    }
}