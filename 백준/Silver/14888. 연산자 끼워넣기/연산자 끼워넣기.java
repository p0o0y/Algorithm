import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static  int[] operator;
    static int max = -1000000001;
    static int min = 1000000001;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];

        for(int i=0;i<N;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            int cur = Integer.parseInt(st.nextToken());
            operator[i]=cur;
        }

        dfs(1,nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth , int curAmount ){
        if(depth==N){
            min=Math.min(min,curAmount);
            max=Math.max(max,curAmount);
            return;
        }

        for(int i=0;i<4;i++) {
            if(operator[i]==0)
                continue;
            else if(i==0 && operator[i]!=0){
                operator[i]--;
                dfs(depth + 1, curAmount+nums[depth ]);
                operator[i]++;
            }
            else if(i==1 && operator[i]!=0){
                operator[i]--;
                dfs(depth + 1, curAmount-nums[depth ]);
                operator[i]++;
            }

            else if(i==2 && operator[i]!=0){
                operator[i]--;
                dfs(depth + 1, curAmount*nums[depth ]);
                operator[i]++;
            }

            else if(i==3 && operator[i]!=0){
                operator[i]--;
                int Amount=0;
                if(curAmount<0){
                     Amount = -(Math.abs(curAmount)/nums[depth]);
                }
                else{
                    Amount=curAmount/nums[depth];
                }
                dfs(depth + 1, Amount);
                operator[i]++;
            }
        }
    }
}
