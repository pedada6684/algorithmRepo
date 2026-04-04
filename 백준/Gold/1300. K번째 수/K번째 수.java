import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        long min = 1;
        long max = N*N;

        while (min < max){
            long mid = (max+min)/2;

            long result = work(mid);
            if(result < K){
                min = mid+1;
            }else{
                max = mid;
            }
        }

        System.out.println(min);
    }

    private static long work(long t) {
        long cnt = 0;
        for (int i = 1; i < N+1; i++) {
            if(i > t) break;
            cnt += Math.min(t/i, N);
        }
        return cnt;
    }
}
