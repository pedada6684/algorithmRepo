import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int maxv = Integer.MAX_VALUE/3;
    static int[][] arr;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }
        memo = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], maxv);
        }
        System.out.println(dp(0,N-1));
    }

    private static int dp(int s, int e) {
        if (memo[s][e] != maxv){
            return memo[s][e];
        }if (s == e){
            return 0;
        }
        for (int i = s; i < e; i++) {
            memo[s][e] = Math.min(memo[s][e], dp(s,i) + dp(i+1,e) + arr[s][0] * arr[i][1] * arr[e][1]);
        }
        return memo[s][e];
    }
}
