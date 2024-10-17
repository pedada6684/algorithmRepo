import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int MAXV = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] memo = new int[K+1];
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);
        Arrays.fill(memo, MAXV);
        memo[0] = 0;
        for (int i = N-1; i >= 0; i--) {
            int coin = coins[i];
            for (int j = coin; j < K+1; j++) {
                memo[j] = Math.min(memo[j], memo[j-coin] + 1);
            }
        }
        System.out.println(memo[K] != MAXV ? memo[K] : -1);
    }
}