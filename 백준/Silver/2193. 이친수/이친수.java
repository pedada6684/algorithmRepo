import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] memo = new long[N+1];
        long[] one = new long[N+1];
        memo[1] = 1;
        one[1] = 1;
        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i-1]*2-one[i-1];
            one[i] = memo[i-1]-one[i-1];
        }
        System.out.println(memo[N]);
    }
}