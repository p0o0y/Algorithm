
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
* a-b
* a - c ->  b   => a랑 b랑 친구
* 2-친구 제일많은 사람의 2-친구 수 구하기
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        //⭐ hashset 배열 만들기
        HashSet<Integer>[] sets = new HashSet[num];
        for (int i = 0; i < num; i++) {
            sets[i] = new HashSet<>();
        }

        //직접 친구 넣기
        for (int i = 0; i < num; i++) {
            String friends = br.readLine();
            for (int j = 0; j < num; j++) {
                if (friends.charAt(j) == 'Y')
                    sets[i].add(j);
            }
        }

        int max =0;

        // 각 사람마다 2-친구를 새로 계산
        for(int i=0;i<num;i++){
            HashSet<Integer> twoFriendsSet = new HashSet<>();
            for(int k : sets[i]){
                //i의 직접 친구넣기
                twoFriendsSet.add(k);

                for(int j : sets[k]){
                    if(j!=i)
                        twoFriendsSet.add(j);
                }

            }
            max = Math.max(max,twoFriendsSet.size());
        }
    System.out.println(max);

    }
}

