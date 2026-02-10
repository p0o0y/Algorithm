import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 감소하는 수
* 0 1 2 3 4 5 6 7 8 9 10
* 20 21
* 30 31 32
* 40 41 42 43
* 90 91 92 ~ 98
* 1.모든 감소하는 수를 만들어 봐야함
* 2.나온 수 정렬하고 인덱스 붙임
* 조합 (0~9) 에서 원소를 뽑아서 만드는 원소의 개수
* dfs인자 - > 현재 상태 , 다음 숫자
* 보통 결과물 + (위치/제약 )
* */
public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //처음시작이 i인 수
        for(int i=0;i<=9;i++){
            dfs(i,i);
        }

        Collections.sort(list);

        if(list.size()>N) System.out.println(list.get(N));
        else System.out.println(-1);

    }
    // 현재까지 만든수 / 마지막에 쓴 수
    static void dfs(long curNum , int lastDigit){
        list.add(curNum);
        for(int i=0;i<lastDigit;i++){
            dfs(curNum*10+i,i);
        }
    }
}
