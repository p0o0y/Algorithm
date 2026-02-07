import java.util.*;

// 처음 만나는 큰 수 -> stack !!!! 
class Solution {
    public int[] solution(int[] numbers) {
      Deque<Integer> stack = new ArrayDeque<>();
      int len =  numbers.length;
        
      int[] ans = new int[len];
      Arrays.fill(ans, -1);
      int index =0;
     
        while(index<len){
               while(!stack.isEmpty()&&numbers[stack.peek()] < numbers[index]){
                   int big = numbers[index];
                   ans[stack.pop()] = big;
               }
            //인덱스 넣기
            stack.push(index);
            index++;
            
        }
        return ans;
        
        }
}