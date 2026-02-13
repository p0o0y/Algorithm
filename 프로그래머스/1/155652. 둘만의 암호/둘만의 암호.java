import java.util.*;

class Solution {
    Set<Character> set = new HashSet<>();
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0;i<skip.length();i++){
            set.add(skip.charAt(i));
        }
        
        for(int i=0;i<s.length();i++){
           answer = answer+change(s.charAt(i), index);
        }
        
        return answer;
    
    }
    /*char + char 은 int 라서
    String + 를 해야 유니코드 */
    public String change(char a,  int index){
        char ans = a;
            for(int i=0;i<index;i++){
                ans++;
                
                if(ans>'z') ans = 'a';
                    
                while(set.contains(ans)){
                    // ans=ans+1;   char + int ==> int 나와서 안됨 
                    ans = (char)(ans+1);
                    if(ans>'z') ans = 'a';
                }
            }
            
        
        return ans+""; // "" 붙이면 char이 스트링 됨 
    }
}