import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] page;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        page = new boolean[N+1];
        memo = new int[2][N+1];
        Arrays.fill(memo[0], -1);
        Arrays.fill(memo[1], -1);
        page[0] = true;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            page[Integer.parseInt(st.nextToken())] = true;
        }
        System.out.println(dp(0, 1));
    }

    private static int dp(int pp, int idx) {
        if (idx == memo[0].length){
            return 0;
        }if (memo[pp][idx] != -1){
            return memo[pp][idx];
        }
        int addCost = pp == 1 ? 2 : 7;
        if (!page[idx]){
            memo[pp][idx] = dp(1, idx+1)+addCost;
        }else{
            memo[pp][idx] = Math.min(dp(1, idx + 1) + addCost, dp(0, idx + 1));
        }
        return memo[pp][idx];
    }
}
