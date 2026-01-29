import java.util.*;

class Solution {
     List<String> answer = new ArrayList<>();
     boolean[] visited;
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets,(a,b)->{return a[1].compareTo(b[1]);});
        visited = new boolean[tickets.length];
        dfs("ICN",tickets);
        return answer.toArray(new String[0]);
    }
    
    public boolean dfs(String airPort,String[][] tickets){
         answer.add(airPort);
      // 모든 티켓은 다 사용해야한다는 조건
        if(answer.size()==tickets.length+1){
            return true;
        }
       
        
        int i=0;
        for(String[] ticket : tickets){
            String from = ticket[0];
            String to = ticket[1];
            if(airPort.equals(from)&&!visited[i]){
                visited[i]=true;
               if (dfs(to, tickets)) return true;
                visited[i]=false;
            }
            i++;
        }
        answer.remove(answer.size() - 1); // 추가했던 공항을 다시 빼줌 (핵심!)
        return false;
    }
}