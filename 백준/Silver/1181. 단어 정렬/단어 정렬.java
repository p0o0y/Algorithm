import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->
        {//1번 길이순
            if(a.length()!=b.length())
                return a.length()-b.length();
            else
                return a.compareTo(b);
        });

        // pq에 넣기
        for(int i=0;i<N;i++){
            String cur = br.readLine();
            if(!pq.contains(cur))
                pq.add(cur);
        }

        StringBuilder sb = new StringBuilder();
        int size = pq.size();
        for(int i=0;i<size;i++){
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }

}
