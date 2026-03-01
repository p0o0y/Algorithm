import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*앞 칸의 배치가 다음칸 영향
* 선형 + 상태선택 dp[i][j]
*  한 열에 올 수있는 경우의 수 (아무것도 , 위에 , 아래만 )*/
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 동물을 놓을 수있는 경우의 수 0 : 아무동물 X 1 :첫번째칸 , 2: 두번째칸
        int[][] dp = new int[N+1][3];

        dp[1][0]=1;
        dp[1][1]=1;
        dp[1][2]=1;

        for(int i=2;i<=N;i++){
            dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901;
            dp[i][2]=(dp[i-1][0]+dp[i-1][1])%9901;
        }
        System.out.println((dp[N][0]+dp[N][1]+dp[N][2])%9901);
    }
}
