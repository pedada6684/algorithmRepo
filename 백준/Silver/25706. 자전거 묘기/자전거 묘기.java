import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        memo = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i] = -1;
        }
        for (int i = 0; i < N; i++) {
            if (memo[i] == -1) dp(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int s : memo) {
            sb.append(s+" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int dp(int idx) {
        if (idx >= arr.length) return 0;
        if (memo[idx] != -1) return memo[idx];
        return memo[idx] = dp(idx+arr[idx]+1)+1;
    }
}
