
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*https://www.acmicpc.net/problem/11047*/

/* 1. DP ()원을 만드는 최소 개수를 계속 만들어 ()원일 때 최적의 값을 계속 저장해서
* 중복계산을 줄일 수있음 ->시간 복잡도 10^9 해야하니까 안됨
*
* -> 조건에 배수라는게 있음 : 큰 동전 쓰는게 무조건 이득 , 정렬해도 변화 X ->그리디
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] coins = new Integer[N];

        for(int i=0;i<N;i++){
            coins[i]=Integer.parseInt(br.readLine());
        }
        //Collections는 객체에만 적용됨
        Arrays.sort(coins, Collections.reverseOrder());

       int money = K;
       int cnt=0;

       while(money>0) {
           for (int coin : coins) {
               if (money - coin >= 0) {
                   money = money - coin;
                   cnt++;
                   break;
               }
           }
       }
        if (money == 0)
            System.out.println(cnt);
        }

    }
