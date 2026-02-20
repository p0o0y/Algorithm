import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // queue의 ()안에는 빈 값 or collections 만 가능
        Queue<String> q1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> q2 = new ArrayDeque<>(Arrays.asList(cards2));
        
        int index =0;
        while(index<goal.length){
            String curNeed = goal[index];
            if(curNeed.equals(q1.peek())){
                q1.poll();
            }
            else if(curNeed.equals(q2.peek())){
                q2.poll();
            }
            else if(!curNeed.equals(q1.peek())&&!curNeed.equals(q2.peek())){
                return "No";
            }
            index++;
            
        }
        return "Yes";
    }
}