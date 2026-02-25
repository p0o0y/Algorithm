import java.util.*;
/* o(n) 에서 끝내야함 , 순서가 중요함
일단 미래를 보고(알아야) 과거를 바꿈 일단 넣고  나중에 처리해  -> pq */
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
      
        int ans = 0;
        for(int i=0;i<enemy.length;i++){
            //일단 순서대로 적용
            n-= enemy[i];
            pq.add(enemy[i]);
            if(n<0){
                if(k>0){
                    n+=pq.poll();
                    k--;
                }
                else
                    break;
            }
               ans++;
           
      }
        return ans;
        
    }
}