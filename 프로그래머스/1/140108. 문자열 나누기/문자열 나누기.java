import java.util.*;
/*문자열 나누기 substring*/
class Solution {
    public int solution(String s) {
        int ans =0;
        int same =0;
        int diff =0;
        char cur = 0;;      
        for(int i=0;i<s.length();i++){
            //새로운 덩어리 시작
            if(same == 0){
                cur = s.charAt(i);
                same =1;
                diff =0;
            }
            //원래 있던거
            else{
                if(s.charAt(i)==cur){
                    same++;
                }
                else{
                    diff++;
                }
            }
            
            //same == diff면 분리
            if(same==diff){
                ans++;
                same=0;
                diff=0;
            }
        }
        //마지막 덩어리
        if(same!=0){
            ans++;
        }
        return ans;
    }
}