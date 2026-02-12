import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*스트링에서의 포함 여부 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String need ="";

        int needLen = N*2+1;
        for(int i=0;i<=N*2;i++){
            if(i%2==0) need = need+"I";
            else need = need+"O";
        }

        int ans =0;

        for(int i=0;i<M;i++){
            if(i+needLen<=M) {
                String s = S.substring(i, i + needLen);
                if(s.equals(need)) ans++;
            }
        }
        System.out.print(ans);
    }
}
