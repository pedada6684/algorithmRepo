import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int maxv = 500*10000*5;
    static int[][] memo;
    static int[][] memo2;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            arr = new int[N+1];
            memo = new int[N][N];
            for (int[] ints : memo) Arrays.fill(ints, maxv);
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
            }
            sb.append(dp(0,N-1)+"\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static int dp(int s, int e) {
        if (s == e){
            return memo[s][e] = 0;
        }if (memo[s][e] != maxv){
            return memo[s][e];
        }
        int minv = maxv;
        for (int i = s; i < e; i++) {
            minv = Math.min(minv, dp(s,i) + dp(i+1,e) + arr[e+1] - arr[s]);
        }
        return memo[s][e] = minv;
    }
}
