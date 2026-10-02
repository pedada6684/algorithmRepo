import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a,b) -> 
             a[1] != b[1] ? a[1] - b[1] : 
                                (a[0] != b[0] ? a[0] - b[0] : a[2]-b[2]));
        
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b) -> 
             a[0] != b[0] ? a[0] - b[0] : 
                                (a[1] != b[1] ? a[1] - b[1] : a[2]-b[2]));
        
        for(int i = 0; i < jobs.length ; i++){
            pq1.add(new int[]{jobs[i][1], jobs[i][0], i}); // l, s, i
        }
        
        pq2.add(pq1.poll());
        
        int t = pq2.peek()[1];
        
        while(!pq2.isEmpty()){
            int[] now = pq2.poll();
            t += now[0];
            answer += (t-now[1]);
            
            while(!pq1.isEmpty()&&pq1.peek()[1] <= t){
                pq2.add(pq1.poll());
            }
            
            if(pq2.isEmpty()&&!pq1.isEmpty()){
                pq2.add(pq1.poll());
                t = pq2.peek()[1];
            }
        }
        
//         3
//         9 7
//         18 17
            
        
        return answer/jobs.length;
        // return answer;
    }
}