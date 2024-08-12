import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        long[] sumArr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        sumArr[0] = 0;
        for (int i = 0; i < N; i++) {
            sumArr[i+1] = sumArr[i] + Integer.parseInt(st.nextToken());
        }
        int length = Integer.MAX_VALUE;

        int start = 0;
        int end = 1;
        long ans;

        while (start < N){
            if (start == end){
                end++;
            }if (end > N){
                end = N;
                start++;
            }
            ans = sumArr[end] - sumArr[start];
            if (ans >= S){
                length = Math.min(length, end - start);
                start++;
            }else {
                end++;
            }
        }
        if (length == Integer.MAX_VALUE) length = 0;
        System.out.println(length);
    }
}
