import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,M;
    static int[][] map;
    static int[][] memo;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        memo = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }
        System.out.println(dp(0,0));
    }

    private static int dp(int i, int j) {
        if (memo[i][j] != -1){
            return memo[i][j];
        }if (i == N-1 && j == M-1){
            return memo[i][j] = 1;
        }

        memo[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int nx = i+dx[d];
            int ny = j+dy[d];
            if (0<= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] < map[i][j]){
                memo[i][j] += dp(nx, ny);
            }
        }
        return memo[i][j];
    }
}
