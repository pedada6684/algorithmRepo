import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] memo;
    static boolean[][] visited;
    static int[] sumArr;
    static int NEG = Integer.MIN_VALUE/2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sumArr = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1] + a;
        }

        memo = new int[N][M+1];
        visited = new boolean[N][M+1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], NEG);
        }

        int dp = dp(N-1, M);

        System.out.println(dp);
    }

    private static int dp(int n, int m) {
        if (m == 0) return 0;
        if (n < 0) return NEG;

        if (visited[n][m]) {
            return memo[n][m];
        }
        visited[n][m] = true;

        int dp1 = dp(n - 1, m);
        int dpFor = NEG;
        for (int i = 0; i < n + 1; i++) {
            int prev = dp(i - 2, m - 1);
            dpFor = Math.max(dpFor, prev + sumArr[n + 1] - sumArr[i]);
        }

        memo[n][m] = Math.max(dp1, dpFor);
        return memo[n][m];
    }
}
