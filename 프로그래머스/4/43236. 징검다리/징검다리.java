import java.util.*;
class Solution {
    static int D;
    static int[] R;
    static int N;
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        D = distance;
        N = n;
        Arrays.sort(rocks);
        R = new int[rocks.length+1];
        for(int i = 0; i < rocks.length ;i++){
            R[i] = rocks[i];
        }
        R[rocks.length] = distance;
        
        int s = 0;
        int e = 1000000000;
        
        while(s <= e){
            int m = (s+e)/2;
            // System.out.println(m);
            if(check(m)){
                answer = m;
                s = m+1;
            }else{
                e = m-1;
            }
            
        }
        
        return answer;
    }
    
    public boolean check(int m){
        int s = 0;
        int n = 0;
        for(int i = 0; i < R.length; i++){
            int r = R[i];
            int d = r-s;
            if(m <= d) {
                s = r;
            }else{
                n++;
            }
        }
        
        return n<=N;
    }
}