import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> table;
    static int ans;
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        table = new ArrayList<>();
        ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            table.add(new int[] {t,p});
        }
        dp = new int[N];
        dp(0);
        System.out.println(dp[0]);
    }

    private static int dp(int idx) {
        if (idx == N){
            return 0;
        }else if (idx > N){
            return Integer.MIN_VALUE;
        }else if (dp[idx] != 0){
            return dp[idx];
        }
        int[] value = table.get(idx);
        int result = Math.max(dp(idx + 1), dp(idx + value[0]) + value[1]);
        dp[idx] = result;
        return result;
    }
}
