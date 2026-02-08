
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 배열에서 나보다 작은 갯수 찾기
* N = 10^6 이라서 2중 for문 X
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 기본배열 1개 , 정렬할 거 1개
        for(int i=0;i<N;i++){
            int a =Integer.parseInt(st.nextToken());
            nums[i]=a;
            set.add(a);
        }

        //1.중복 포함 하면 안되니까 Set -> List로 만들기
        //2. List sort는 Collection.sort(list)
        List<Integer> sortnums = new ArrayList<>(set);
        Collections.sort(sortnums);
        // 2, 4, -10, 4, -9
        //- 10(0) -9(1) 2(2) 4(3)

//      이중 포문 안됨
//        for(int i=0;i<N;i++){
//            int sum =0;
//            for(int j=0;j<N;j++){
//                if(nums[i]>sortnums.get(j))
//                    sum++;
//                else break;
//            }
//            sb.append(sum).append(" ");
//        }

        // 값 : 나보다 작은 수 (인덱스로)
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<sortnums.size();i++){
            map.put(sortnums.get(i),i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(map.get(nums[i])).append(" ");
        }
        System.out.println(sb.toString());

    }

}