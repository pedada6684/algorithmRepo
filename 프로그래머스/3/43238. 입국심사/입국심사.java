class Solution {
    static int N;
    static int[] A;
    public long solution(int n, int[] times) {
        long answer = 0;
        N = n;
        A = times;
    
        long s = 0;
        long e = (long)times[0] * n;
        
        while(s <= e){
            long m = s+(e-s)/2;
            if(check(m)){
                e = m-1;
                answer = m;
            }else{
                s = m+1;
            }
        }
        
        return answer;
    }
    
    public boolean check(long t){
        long res = 0;
        for(int i = 0; i < A.length ; i++){
            res += t/A[i];
        }
        return res >= N;
    }
    
}