import java.util.*;

class Solution {
    char[][] map;
    int rowLen;
    int colLen;
    public int[] solution(String[] park, String[] routes) {
         rowLen = park.length;
         colLen = park[0].length();
        
        int curX =0;
        int curY =0;
        
         map = new char[rowLen][colLen];
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(park[i].charAt(j)=='S'){
                    curX = i;
                    curY = j;
                }
                map[i][j]=park[i].charAt(j);
            }
        }
      
        for(String route : routes){
           String[] parts = route.split(" ");
           char dir = parts[0].charAt(0);
           int w = Integer.parseInt(parts[1]);
            
            if(check(curX,curY,dir,w)) {
                // 2. 성공하면 실제 위치를 업데이트
                if (dir == 'N') curX -= w;
                else if (dir == 'S') curX += w;
                else if (dir == 'W') curY -= w;
                else if (dir == 'E') curY += w;
            }
        }
        return new int[]{curX,curY};
    }
    
    public boolean check (int x , int y , char dir , int w){
        for(int i=0;i<w;i++){
            if(dir=='W') y--;
            else if(dir=='S') x++;
            else if(dir=='E') y++;
            else x--;
            if( x<0 || x>=rowLen || y<0 || y>=colLen || map[x][y]=='X') return false;
        }
        return true;
    }
}