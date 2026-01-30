import java.util.*;
class Solution {
    // 순서가 정해져 있음 - 
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       // 1번 트럭 in if bridge_length (큐안size확인) 더 넣어 
        Queue<int[]> queue = new ArrayDeque<>();
       
        int idx= 0;
        int second =0;
        int curTotal =0;

        while(idx < truck_weights.length){
             // 길이 다 지나가면 total에서 빼줘야함 
            
         if (!queue.isEmpty() && queue.peek()[1] == second) {
                curTotal -= queue.poll()[0];
            }
            
            //추가 가능하면 현재 트럭의 무게가 
            if(curTotal+truck_weights[idx]<=weight && queue.size()<=bridge_length){
                queue.add(new int[]{truck_weights[idx],second+bridge_length});
                curTotal += truck_weights[idx];
                idx++;
            }
           second++;
        }
       return second+(bridge_length);
    }
}