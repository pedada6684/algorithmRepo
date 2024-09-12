import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int MAXV = 16*1000000+1;
    static int[][] distance;
    static int[][][] memo;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        memo = new int[N][N][(1<<N)];
        for (int[][] squre : memo) {
            for (int[] row : squre) {
                Arrays.fill(row, -1);
            }
        }
        int ans = MAXV;
        for (int i = 0; i < N; i++) {
            ans = Math.min(ans, dp(0, 1<<i, i, i));
        }
        System.out.println(ans);
    }

    private static int dp(int idx, int state, int start, int now) {
        if (state == (1 << N) - 1){ // 마지막 도시
            if (distance[now][start] == 0) return MAXV;
            return distance[now][start];
        }if (memo[start][now][state] != -1){
            return memo[start][now][state];
        }
        int res = MAXV;
        for (int i = 0; i < N; i++) {
            if ((state & 1<<i) != 0 || distance[now][i] == 0) continue;
            res = Math.min(res, dp(idx+1, state | (1<<i), start, i) + distance[now][i]);
        }
        memo[start][now][state] = res;
        return res;
    }
}