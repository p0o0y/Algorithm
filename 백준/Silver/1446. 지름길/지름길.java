import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 지름길 N개 총 길이 D --- 최소 길이 구하기
* start end length
* 150 전 ) start - end 같으면 최소인거
* 지금까지 온곳 --> 150이전 까지 최소 찾기
* 없으면 쌩으로 가야함
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 1. 그래프 만들기
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(end<=D) {
                graph.get(0).add(new int[]{start, end, w});
            }
        }

        // dp i 까지 가는데 최소값
        int[] dp = new int[10001];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0]=0;
        dp[1]=1;

        for(int i=1;i<=D;i++){

            dp[i]=Math.min(dp[i],dp[i-1]+1);

            for(int j=0;j<graph.get(0).size();j++){
                int s =graph.get(0).get(j)[0];
                int e = graph.get(0).get(j)[1];
                int w = graph.get(0).get(j)[2];
                
                if(e==i){
                    dp[i]=Math.min(dp[i],w+dp[s]);
                }
            }
        }
        System.out.println(dp[D]);

    }
}
