import java.util.*;

/*
*/
class Solution {
      int[] dr = {0,0,1,-1};
      int[] dc  ={1,-1,0,0};
      List<Integer> ans = new ArrayList<>();
    public int[] solution(String[][] places) {
        for(String[] place : places){
            ans.add(bfs(place));
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
    
    public int bfs(String[] place){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                //사람P 마다 Queue , visited만들어서 해당 P는 통과되는지 파악 
                if(place[i].charAt(j)=='P'){
                    Queue<int[]> queue = new ArrayDeque<>();
                    boolean[][] visited = new boolean[5][5];
                    queue.add(new int[]{i,j,0});
                    visited[i][j]=true;
                    
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int curX = cur[0];
                        int curY=cur[1];
                        int curD = cur[2];
                        
                        for(int k=0;k<4;k++){
                            int nextX = curX+dr[k];
                            int nextY = curY+dc[k];
                            int nextD = curD+1;
                            if(nextX>=0&& nextX<5 && nextY>=0 && nextY<5 && !visited[nextX][nextY]){
                                if(curD>3) continue;
                                
                                if(place[nextX].charAt(nextY)=='P'&& nextD<=2)
                                    return 0;
                                
                                if(place[nextX].charAt(nextY)=='O'){
                                    visited[nextX][nextY]=true;
                                    queue.add(new int[]{nextX,nextY,nextD});
                                }
                        }
                    }
                    }
                }
                
            }
        }
        return 1;
    }
}