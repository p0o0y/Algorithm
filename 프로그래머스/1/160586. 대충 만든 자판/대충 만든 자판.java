import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
       int len = targets.length;
        int[] answer = new int[len];
      
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<keymap.length;i++){
            for(int j=0;j<keymap[i].length();j++){
                // 1. 그 값 없으면 일단 넣기 
                if(!map.containsKey(keymap[i].charAt(j))){
                    map.put(keymap[i].charAt(j),j+1);
                }
                //2. 있으면 비교해서 넣기
                else{
                    int cur = map.get(keymap[i].charAt(j));
                    if(cur<j+1) continue;
                    else{
                        map.put(keymap[i].charAt(j),j+1);
                    }
                }
            }
        }
        for(int i=0;i<targets.length;i++){
            int ans =0;
            for(int j=0;j<targets[i].length();j++){
                if(!map.containsKey(targets[i].charAt(j))){
                    ans=-1;
                    break;
                }
                ans+=map.get(targets[i].charAt(j));
            }
            answer[i]=ans;
        }
        
        return answer;
        
    }
}