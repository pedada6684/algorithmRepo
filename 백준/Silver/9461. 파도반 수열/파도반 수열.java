import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] input = new int[T];
        int size = 6;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            input[tc] = Integer.parseInt(st.nextToken());
            size = Math.max(size, input[tc]);
        }
        memo = new long[size+1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;
        memo[5] = 2;
        memo[6] = 3;
        dp(memo.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i : input) {
            sb.append(memo[i]+"\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static long dp(int n) {
        if (n <= 0){
            return 0;
        }if (memo[n] != -1){
            return memo[n];
        }
        return memo[n] = dp(n-1) + dp(n-5);
    }
}