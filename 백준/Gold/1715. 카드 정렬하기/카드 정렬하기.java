
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        // 10^5
        // (1+2) + ((1+2)+ 3) -> 맨 마지막에 더하는게 제일 큰 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
           pq.add(Integer.parseInt(br.readLine()));
        }


        int total=0;
        int currentSum=0;
        // 가장 작은 것끼리 더해야함
        while(!pq.isEmpty()){
            int first = pq.poll();
            if(pq.isEmpty()){
                System.out.println(total);
                break;
            }
            int second = pq.poll();
             currentSum = first+second;
            total += currentSum;
            pq.add(currentSum);
        }

    }
}


