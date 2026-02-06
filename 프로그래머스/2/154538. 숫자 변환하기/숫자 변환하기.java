import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
       
        // 최소라서 queue 넣는데 visited 상관없이 그 위치에서 최소면 갱신돼야함
        int[] counts = new int[1000001];
        Arrays.fill(counts,1000001);
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{x,0});
        
        if(x==y) return 0;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0] , count=cur[1];
            
            // 지금 값이 이미 counts 값보다 크면 버려 최소를 이미 찾았으니
            if(count>counts[curX])
                continue;
            
            if(curX+n<= y&& count+1<counts[curX+n]){
                counts[curX+n]=count+1;
                queue.add(new int[]{curX+n,count+1});
            }
            
            if( curX*2<=y&& count+1<counts[curX*2] ){
                counts[curX*2]=count+1;
                queue.add(new int[]{curX*2,count+1});
            }
            
            if(curX*3<=y&&count+1<counts[curX*3]){
                counts[curX*3]=count+1;
                queue.add(new int[]{curX*3,count+1});
            }
        }
        if(counts[y]!=1000001)
            return counts[y];
        else 
            return -1;
    }
}