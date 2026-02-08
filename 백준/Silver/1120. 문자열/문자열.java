import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String sStr = st.nextToken();
        String lStr = st.nextToken();
        int diff =Integer.MAX_VALUE;

        //경우 1) 만약 a길이 b길이 같으면 다른 것만 파악
        if(sStr.length()==lStr.length()){
            diff =0;
            for(int i=0;i<sStr.length();i++){
                if(sStr.charAt(i)!=lStr.charAt(i))
                    diff++;
            }
        }

       // 경우 2) 길이 다른경우 : 길이 긴애 0번 idx 부터 짧은 길이만큼만 파악해서 min 개수
        else{
            int Slen = sStr.length();
            int Llen = lStr.length();

            for(int i=0;i<=Llen-Slen;i++){
                int index =0;
                int dif =0;
                while(index<Slen){
                    if(sStr.charAt(index)!=lStr.charAt(i+index)){
                        dif++;
                    }
                    index++;
                }
                diff = Math.min(diff,dif);
            }

        }
        System.out.print(diff);
    }
}
