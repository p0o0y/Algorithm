
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] visited;  //행 열
    static int cnt=0;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[N+1];
        dfs(1);
        System.out.println(cnt);
    }

    // 1행에 1개 찍었으면 2행에서 1열 ~ 끝열 파악
    static void dfs(int row){
       if(row==N+1) {
           cnt++;
           return;
       }
       for(int i=1;i<=N;i++){
           visited[row]=i; // 일단 앉혀놓고
           if(promising(row)){
                dfs(row+1);
           }
           visited[row]=0;
       }
    }

    static boolean promising(int row){
        for(int i=1;i<row;i++){
            if(visited[row]==visited[i]) return false;    // 1.같은 열에 퀸이 있는지
            if(Math.abs(row-i)==Math.abs(visited[row]-visited[i])) return false;     //2.대각선 행-행 열-열
        }
        return true;
    }
}