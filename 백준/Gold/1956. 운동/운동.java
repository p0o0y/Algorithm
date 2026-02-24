
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<=V;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st= new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        int[] ans = new int[V+1];

        //시작점으로 돌아와야해
        for(int i=1;i<=V;i++){
            int[] dist = new int[V+1];
            Arrays.fill(dist,10000*V+1);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
            pq.add(new int[]{i,0});

            while(!pq.isEmpty()) {
                int[] curq = pq.poll();
                int curX = curq[0];
                int curD = curq[1];
                //이미 최소이면 넘어감
                if(curD>dist[curX]) continue;

                for (int[] next : graph.get(curX)) {
                    int nextX = next[0];
                    int nextD = next[1];
                    //여기 거쳐가는게 괜찮으면 pq에 넣어줌
                    if(curD+nextD<dist[nextX]){
                        pq.add(new int[]{nextX,nextD+curD});
                        dist[nextX]=nextD+curD;
                    }

                }
            }
            if(dist[i]!=10000*V+1){
                ans[i]=dist[i];
            }
            else ans[i]=-1;
        }

        int min = Integer.MAX_VALUE;

        for(int i=1;i<=V;i++){
            if(ans[i]!=-1)
                min = Math.min(min,ans[i]);
        }

        if(min==Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}


