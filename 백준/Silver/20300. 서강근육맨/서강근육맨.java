import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] vals = new long[N];


        for(int i=0;i<N;i++){
            vals[i]=Long.parseLong(st.nextToken());
        }

        //⭐ 그리디에서 정렬은 거의 필수 ( 보장해줘야함)
        Arrays.sort(vals);

        //✔️ 10^18값은 long타입 10^9까지만 int
        long max = 0;
        // 짝수
        if(N%2==0) {
            for(int i=0;i<N/2;i++){
                max = Math.max(max,vals[i]+vals[N-1-i]);
            }
        }
        else if(N%2==1){
            max = vals[N-1];
            for(int i=0; i<(N-1)/2; i++){
                max = Math.max(max,vals[i]+vals[(N-2)-i]);
            }
        }

        System.out.println(max);

    }
}
