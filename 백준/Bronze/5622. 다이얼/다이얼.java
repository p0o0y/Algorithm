
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*char 값 -> 숫자로 매핑하기  */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int len = code.length();

        HashMap<Character,Integer> map = new HashMap<>();
       char a = 'A';
       int cnt = 0;

       while(a!='Z'){
           if(a=='S'){
               a++;
               continue;
           }

           map.put(a,cnt/3+3);
           cnt++;
           a++;
       }
       map.put('S',8);
       map.put('Z',10);

       int ans =0;

       for(int i=0;i<len;i++){
           if(map.containsKey(code.charAt(i)))
               ans+=map.get(code.charAt(i));
       }
       System.out.println(ans);
    }
}