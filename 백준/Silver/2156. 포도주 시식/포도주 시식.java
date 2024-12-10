import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        memo = new int[N][2];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dp(0,0));

    }

    private static int dp(int idx, int take) {
        if (idx == memo.length){
            return 0;
        }if (take == 2){
            return dp(idx+1, 0);
        }if (memo[idx][take] != -1){
            return memo[idx][take];
        }
        return memo[idx][take] = Math.max(
                dp(idx+1, take+1)+ arr[idx],
                dp(idx+1, 0)
        );
    }
}
