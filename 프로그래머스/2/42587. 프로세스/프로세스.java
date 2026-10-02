import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int i = 0; i < priorities.length ; i++){
            int p = priorities[i];
            pq.add(p);
            if(i == location){
                q.add(new int[] {p,1});
            }else{
                q.add(new int[] {p,0});
            }
        }
        
        while(!q.isEmpty()){
            
            int[] now = q.poll();
            int m = pq.peek();
            
            if(now[0] == m){
                pq.poll();
                answer++;
                if(now[1] == 1){
                    return answer;
                }
            }else{
                q.add(now);
            }
        }
        
        return -1;
    }
}