
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Node(age,name));
        }

        list.sort((a,b)->a.age-b.age);

        StringBuilder sb = new StringBuilder();
        for(Node m : list){
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.println(sb);
    }
    static class Node {
        int age;
        String name;
        Node(int age , String name){
            this.age=age;
            this.name=name;
        }
    }
}