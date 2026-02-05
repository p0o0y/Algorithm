import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
       int[] ans = new int[photo.length];
       Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        
         int i=0;
        for(String[] pho : photo){
            int total =0;
            for(String p : pho){
                if(map.containsKey(p)){
                    total+=map.getOrDefault(p,0);
                }            
            }
            ans[i]=total;
            i++;
        }
        return ans;
    }
}