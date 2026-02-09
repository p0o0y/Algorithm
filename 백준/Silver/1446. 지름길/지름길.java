
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            // 1. 그래프 만들기
            List<List<int[]>> graph = new ArrayList<>();
            for (int i = 0; i <= D; i++) {
                graph.add(new ArrayList<>());
            }
            //기본 도로 가중치
            for(int i=0;i<D;i++){
                graph.get(i).add(new int[]{i+1,1});
            }
            //지름길 가중치 (시작->끝/가중치)
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                if (end <= D) {
                    graph.get(start).add(new int[]{end, w});
                }
            }
            //가중치 낮은게 먼저
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

            int[] dist = new int[D+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            pq.add(new int[]{0,0}); //현재 위치 , 소모비용
            dist[0]=0;

            while(!pq.isEmpty()){
                int[] cur =pq.poll();
                int curX = cur[0];
                int d  =cur[1];

                if(dist[curX]<d) continue;

                for(int[] next: graph.get(curX)){
                    int nextX=next[0];
                    int nextD=next[1];

                    if(dist[nextX]>dist[curX]+nextD){
                        dist[nextX]=dist[curX]+nextD;
                        pq.add(new int[]{nextX,dist[nextX]});
                    }
                }
            }
            System.out.println(dist[D]);
        }
    }
