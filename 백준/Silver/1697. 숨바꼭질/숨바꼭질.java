import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*최소 시간 구하기 10^5 이므로 이중 포문 X
* visited 한번에 다 하면 안됨 또 방문 가능해서
*그냥 bfs가 아니야 왜냐면 1칸 가는거랑 2칸 가는거 가중치가 다름
* -> 다익스트라 이동하는게 달라서 우선순위가 있음
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dist = new int[100001];
        Arrays.fill(dist,100001);

        q.add(new int[]{N,0}); // 위치,초
        dist[N]=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0] , second = cur[1];

            if(dist[curX]<second) continue;

            if(curX+1<100001){
                if(dist[curX+1]>second+1) {
                    dist[curX+1]=second+1;
                    q.add(new int[]{curX+1,second+1});
                }
            }
            if (curX-1>=0){
                if(dist[curX-1]>second+1){
                    dist[curX-1]=second+1;
                    q.add(new int[]{curX-1,second+1});
                }
            }
            if(curX*2<100001){
                if(dist[curX*2]>second+1){
                    dist[curX*2]=second+1;
                    q.add(new int[]{curX*2,second+1});
                }
            }

        }
        System.out.println(dist[K]);
    }
}