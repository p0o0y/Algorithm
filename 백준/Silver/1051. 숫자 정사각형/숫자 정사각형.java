import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*가장 큰 변은 N M 중 작은 수가 기준 */
public class Main {
    static int N,M;
    static int[][] square;
    static int maxlen =1;

public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
     N = Integer.parseInt(st.nextToken()) ;
     M = Integer.parseInt(st.nextToken());

    square = new int[N][M];
    for(int i=0;i<N;i++){
        String line = br.readLine();
        for(int j=0;j<M;j++){
            //⭐ string 숫자를 int 숫자 -> char -'0'
            square[i][j]=line.charAt(j)-'0';
        }
    }

    int max = Math.min(N,M);

    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            if(check(i,j,max-1)) {

            }
        }
    }
    System.out.println(maxlen*maxlen);
}

    static boolean check(int i , int j , int len){
        for(int k=len;k>0;k--) {
            if (i>=0 && j>=0 && i + k < N && j + k < M) {
                if (square[i][j] == square[i + k][j] && square[i][j + k] == square[i + k][j + k]
                        && square[i + k][j] == square[i][j + k]) {
                    maxlen = Math.max(maxlen,k+1);
                    return true;
                }
            }
        }
        return false;
    }
}
