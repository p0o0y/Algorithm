import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 수열
        dfs(N,M,0,new ArrayList<>());
        System.out.println(sb.toString());
    }

    public static void dfs(int N, int M, int cnt, List<Integer> curr){
        if(cnt==M){
            for(int i=0;i<M;i++){
                sb.append(curr.get(i));
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            if(!set.contains(i)){
                curr.add(i);
                set.add(i);
                dfs(N,M,cnt+1,curr);
                curr.remove(Integer.valueOf(i));
                set.remove(i);
            }
        }
    }
}
