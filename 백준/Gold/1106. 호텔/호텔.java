
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 고객 총 수
        int N = Integer.parseInt(st.nextToken()); // 도시

        // 비용,고객
        int[][] arr = new int[N][2];
        int plus = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            plus= Math.max(plus,arr[i][1]);
        }

        int[] dp = new int[C+1+plus];
        Arrays.fill(dp,100000);
        dp[0]=0;
        for(int i=1;i<=C+plus;i++){
            for(int[] city : arr) {
                int cost = city[0];
                int person = city[1];
                if (i-person>= 0) {
                    dp[i] = Math.min(dp[i],cost+dp[i-person]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=C;i<=C+plus;i++){
            min = Math.min(min,dp[i]);
        }

        System.out.println(min);
    }
}