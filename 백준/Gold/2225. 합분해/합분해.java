import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int limit = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int k = 2; k < dp[0].length; k++) {
            for (int n = 1; n < dp.length; n++) {
                dp[n][k] = (dp[n][k-1] + dp[n-1][k])%limit;
            }
        }

        System.out.println(dp[N][K]);
    }
}