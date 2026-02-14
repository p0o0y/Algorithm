import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        int[][] times= new int[book_time.length][2];
      // 1) 2차원 배열 정렬 + pq (종료시간기준) 만들기
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
      Arrays.sort(book_time,(a,b)->a[0].compareTo(b[0]));
        
      //2) 스트링 -> 분으로 단위 맞춤 
        for(int i=0;i<book_time.length;i++){
            String[] time1 = book_time[i][0].split(":");
            String[] time2 = book_time[i][1].split(":");
            int start = Integer.parseInt(time1[0])*60 + Integer.parseInt(time1[1]);
            int end = Integer.parseInt(time2[0])*60 + Integer.parseInt(time2[1]);
            times[i][0]=start;
            times[i][1]=end;
        }
        
        int index = 0;
        pq.add(new int[]{ times[0][0], times[0][1]});
        int ans =1;
        while(index<book_time.length-1){
            int[] curQ = pq.peek();
           // (가장 빨리 비는 방의 종료시간 + 10분) <= (새 손님의 시작시간) 이라면?
            if(curQ[1]+10<=times[index+1][0]){
                pq.poll();
                pq.add(new int[]{times[index+1][0],times[index+1][1]});
            }
            // 아직 종료 아니면 방 추가 
            else{
                pq.add(new int[]{times[index+1][0],times[index+1][1]});
                ans++;
            }
            index++;
        }
       return ans;
    }
}