import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    static int[] arr;
    static final int minv = -1000*100000;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        memo = new int[N];
        Arrays.fill(memo,minv);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ans = minv;
        dp(0);
        System.out.println(ans);
    }

    private static int dp(int idx) {
        if (idx >= memo.length){
            return 0;
        }if (memo[idx] != minv){
            return memo[idx];
        }
        memo[idx] = Math.max(dp(idx+1)+arr[idx], arr[idx]);
        ans = Math.max(ans, memo[idx]);
        return memo[idx];
    }
}
