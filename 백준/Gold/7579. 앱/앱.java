import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int ans;
    static int[][] dp;
    static int[][] memoryAndPrice;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][10001];
        memoryAndPrice = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memoryAndPrice[i][0] = Integer.parseInt(st.nextToken());
        }
        int zeroPriceCnt = 0;
        int savedMemory = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memoryAndPrice[i][1] = Integer.parseInt(st.nextToken());
            if (memoryAndPrice[i][1] == 0){
                zeroPriceCnt++;
                savedMemory += memoryAndPrice[i][0];
            }
        }
        Arrays.sort(memoryAndPrice, (a, b) -> a[1] - b[1]);
        
        if (M <= savedMemory) {
            System.out.println(0);
        } else {
            M -= savedMemory;
            for (int i = 0; i <= zeroPriceCnt; i++) {
                Arrays.fill(dp[i], M);
            }

            for (int i = zeroPriceCnt + 1; i < dp.length; i++) {
                int memory = memoryAndPrice[i - 1][0];
                int price = memoryAndPrice[i - 1][1];
                for (int j = 0; j < dp[0].length; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (price <= j) {
                        if (dp[i - 1][j - price] - memory <= dp[i][j]) {
                            dp[i][j] = dp[i - 1][j - price] - memory;
                            if (dp[i][j] <= 0) {
                                ans = Math.min(j, ans);
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}